package com.example.news.network

import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org/v2/"

const val API_KEY = "96401775beb042e9ad76523d69b961e0"

interface NewsApiService {
    @GET("top-headlines?country=us&apiKey=${API_KEY}")
    suspend fun getApiResponse(): ApiResponse
}