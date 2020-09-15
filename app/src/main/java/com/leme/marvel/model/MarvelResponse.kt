package com.leme.marvel.model

data class MarvelResponse(
    val total: Int,
    val results: List<Characters>
)