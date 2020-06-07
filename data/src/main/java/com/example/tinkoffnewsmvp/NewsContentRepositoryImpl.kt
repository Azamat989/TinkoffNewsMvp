package com.example.tinkoffnewsmvp

import com.example.tinkoffnewsmvp.dto.newscontent.NewsContent
import com.example.tinkoffnewsmvp.dto.newscontent.NewsPayload
import com.example.tinkoffnewsmvp.repository.news_content.NewsContentRepository
import com.example.tinkoffnewsmvp.services.NewsContentApi
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