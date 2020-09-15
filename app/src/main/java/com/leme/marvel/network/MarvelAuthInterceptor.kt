package com.leme.marvel.network

import okhttp3.Interceptor
import okhttp3.Response

class MarvelAuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request
            .url()
            .newBuilder()
            .addQueryParameter("ts", NetworkConstants.API_DEFAULT_TIMESTAMP)
            .addQueryParameter("apikey", NetworkConstants.API_KEY)
            .addQueryParameter("hash", NetworkConstants.API_HASH)
            .build()

        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }

}