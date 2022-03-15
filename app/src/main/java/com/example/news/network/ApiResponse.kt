package com.example.news.network


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse(
    val articles: List<Article> = listOf(),
    val status: String = "",
    val totalResults: Int = 0
)