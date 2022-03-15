package com.example.news.di

import androidx.room.Room
import com.example.news.data.NewsDatabase
import com.example.news.network.BASE_URL
import com.example.news.network.NewsApiService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val appModule = module {
    single {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build().create(NewsApiService::class.java)
    }

    // Room Database
    single {
        Room.databaseBuilder(androidApplication(), NewsDatabase::class.java, "news_database")
            .build()
    }

    single { get<NewsDatabase>().articleDao() }

}

