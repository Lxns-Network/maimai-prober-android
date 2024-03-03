package net.lxns.maimai.prober.networking.service

import retrofit2.http.GET

interface RemoteService {
    @GET("https://maimai.lxns.net/api/v0/user/profile")
    fun fetchProfile():
}