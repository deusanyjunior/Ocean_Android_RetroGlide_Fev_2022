package com.oceanbrasil.ocean_android_retroglide_fev_2022

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users/{user}/repos")
    fun listarRepositorios( @Path("user") user: String?): Call<List<Repo?>?>?
}