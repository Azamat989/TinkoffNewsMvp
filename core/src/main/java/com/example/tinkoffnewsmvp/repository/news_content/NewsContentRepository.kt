package com.example.tinkoffnewsmvp.repository.news_content

import com.example.tinkoffnewsmvp.dto.newscontent.NewsContent

interface NewsContentRepository {

    suspend fun uploadNewsContent(newsId: String): NewsContent?

}