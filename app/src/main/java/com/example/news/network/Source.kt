package com.example.news.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Source(
    val id: Any? = null,
    val name: String = ""
)