package com.example.tinkoffnewsmvp.news_details

import com.example.tinkoffnewsmvp.dto.newscontent.NewsContent
import com.example.tinkoffnewsmvp.repository.news_content.NewsContentRepository
import javax.inject.Inject

interface NewsDetailsInteractor {

    suspend fun uploadNewsContent(newsId: String): NewsContent?

}

class NewsDetailsInteractorImpl @Inject constructor(
    private val repository: NewsContentRepository
) : NewsDetailsInteractor {

    override suspend fun uploadNewsContent(newsId: String): NewsContent? =
        repository.uploadNewsContent(newsId)

}