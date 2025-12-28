package com.fatchoy.dollar.api

import retrofit2.http.GET

interface ApiService {
    @GET("/temp")
    suspend fun getPost()
}
