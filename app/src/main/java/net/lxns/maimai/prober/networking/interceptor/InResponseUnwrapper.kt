package net.lxns.maimai.prober.networking.interceptor

import com.google.gson.JsonParser
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody

class InResponseUnwrapper : Interceptor {
    override fun intercept(ch: Interceptor.Chain): Response {
        val resp = ch.proceed(ch.request())
        val body = resp.body() ?: return resp
        if (resp.code() >= 400) {
            throw IllegalStateException("${ch.request().url()}: ${resp.code()}")
        }
        if (resp.header("Content-Type") != "application/json") {
            return resp.newBuilder().body(body).build()
        }
        val parsed = JsonParser.parseString(body.string())
        if (!parsed.isJsonObject) {
            throw IllegalStateException("Except json but ${parsed.asString}")
        }
        val jo = parsed.asJsonObject
        return if (jo.has("success")) {
            if (!jo["success"].asBoolean) {
                throw IllegalStateException("Remote error: ${jo["message"]}")
            }
            resp.newBuilder()
                .body(ResponseBody.create(MediaType.get("application/json"), jo["data"].toString()))
                .build()
        } else {
            resp.newBuilder().body(body).build()
        }
    }
}