package com.example.news.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.news.domain.Article

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertArticles(gifs: List<Article>)

    @Query("SELECT * FROM news_table")
    suspend fun getArticles(): List<Article>

}