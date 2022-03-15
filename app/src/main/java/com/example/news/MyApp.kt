package com.example.news

import android.app.Application
import com.example.news.di.appModule
import org.koin.android.ext.android.startKoin

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(appModule)
        )
    }


}