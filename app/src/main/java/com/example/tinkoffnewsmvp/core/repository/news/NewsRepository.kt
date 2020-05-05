package com.example.tinkoffnewsmvp.core.repository.news

import com.example.tinkoffnewsmvp.core.dto.news.NewsBlock

interface NewsRepository {

    suspend fun saveNews(news: List<NewsBlock>)

    suspend fun deleteAll()

    suspend fun getNewsFromServer(): List<NewsBlock>

    suspend fun isDatabaseEmpty(): Boolean

    fun getNewsFromDb(startPosition: Int, loadSize: Int): List<NewsBlock>

}