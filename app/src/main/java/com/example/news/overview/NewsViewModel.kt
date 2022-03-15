package com.example.news.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.data.ArticleDao
import com.example.news.domain.Article
import com.example.news.network.NewsApiService
import kotlinx.coroutines.launch
import org.koin.standalone.KoinComponent
import org.koin.standalone.StandAloneContext

class NewsViewModel : ViewModel(), KoinComponent {
    val retrofitService = StandAloneContext.getKoin().koinContext.get<NewsApiService>()
    val dao = StandAloneContext.getKoin().koinContext.get<ArticleDao>()

    private val _news: MutableLiveData<List<Article>> = MutableLiveData(emptyList())
    val news: LiveData<List<Article>> = _news

    var articlePosition: Int = -1

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            try {
                val news = retrofitService.getApiResponse().articles.map {
                    Article(title = it.title, description = it.description?:" ")
                }
                dao.insertArticles(news)
            } catch (e: Exception) {

            }
            _news.value = dao.getArticles()

        }
    }


}