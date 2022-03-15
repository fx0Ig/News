package com.example.news.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.news.domain.Article

@Database(entities = [Article::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {


    abstract fun articleDao(): ArticleDao

}