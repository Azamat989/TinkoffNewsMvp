package com.example.tinkoffnewsmvp.data.repository

import com.example.tinkoffnewsmvp.core.dto.newscontent.NewsContent
import com.example.tinkoffnewsmvp.core.dto.newscontent.NewsPayload
import com.example.tinkoffnewsmvp.core.repository.news_content.NewsContentRepository
import com.example.tinkoffnewsmvp.core.services.NewsContentApi
import javax.inject.Inject

class NewsContentRepositoryImpl @Inject constructor(
    private val api: NewsContentApi
) : NewsContentRepository {

    override suspend fun uploadNewsContent(newsId: String): NewsContent? =
        api.getNewsContent(newsId)
            .body()
            ?.payload
            ?.toNewsContent()

    private fun NewsPayload.toNewsContent(): NewsContent =
        NewsContent(content)

}