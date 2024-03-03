package net.lxns.maimai.prober.networking.interceptor

import android.content.SharedPreferences
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.prefs.Preferences


private const val PREF_COOKIES = "default_cookies"

class OutCookiesInterceptor(private val pref: SharedPreferences) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        for (cookie in pref.getStringSet(PREF_COOKIES, HashSet())!!) {
            builder.addHeader("Cookie", cookie)
        }

        return chain.proceed(builder.build())
    }
}

class InCookiesInterceptor(private val pref: SharedPreferences) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())
        if (originalResponse.headers("Set-Cookie").isNotEmpty()) {
            val cookies = HashSet<String>()
            for (header in originalResponse.headers("Set-Cookie")) {
                cookies.add(header)
            }
            pref.edit().putStringSet(PREF_COOKIES,cookies).apply()
        }
        return originalResponse
    }

}