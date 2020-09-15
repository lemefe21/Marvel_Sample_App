package com.leme.marvel.data.remote

import com.leme.marvel.model.Resource
import com.leme.marvel.network.MarvelAuthInterceptor
import com.leme.marvel.network.NetworkConstants
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val service: MarvelService by lazy {
    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(MarvelAuthInterceptor())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl(NetworkConstants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    retrofit.create(MarvelService::class.java)
}

fun getMarvelService() = service

interface MarvelService {
    @GET(NetworkConstants.CHARACTERS_ENDPOINT)
    fun getCharacters(): Call<Resource>
}