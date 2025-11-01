package com.fatchoy.dollar.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal fun CreateApiService(apiUrl: String = "TempApiUrl.com") : ApiService {
    val logger = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client = OkHttpClient.Builder()
        .addInterceptor(logger)
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(apiUrl)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    return retrofit.create(ApiService::class.java)
}
