package com.leme.marvel.network

import com.leme.marvel.BuildConfig

object NetworkConstants {
    const val BASE_URL = "https://gateway.marvel.com/v1/public/"
    const val API_KEY =  BuildConfig.API_KEY_MARVEL
    const val API_HASH =  BuildConfig.HASH_MARVEL
    const val CHARACTERS_ENDPOINT = "characters"
    const val API_DEFAULT_TIMESTAMP = "1"
}