package com.example.tinkoffnewsmvp.core.repository.news_content

import com.example.tinkoffnewsmvp.core.dto.newscontent.NewsContent

interface NewsContentRepository {

    suspend fun uploadNewsContent(newsId: String): NewsContent?

}