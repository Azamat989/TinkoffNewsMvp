package com.example.tinkoffnewsmvp.data.repository

import com.example.tinkoffnewsmvp.dto.news.NewsBlock
import com.example.tinkoffnewsmvp.dto.news.NewsBlockEntity
import com.example.tinkoffnewsmvp.dto.news.NewsBlockResponse
import com.example.tinkoffnewsmvp.repository.news.NewsDao
import com.example.tinkoffnewsmvp.repository.news.NewsRepository
import com.example.tinkoffnewsmvp.services.NewsApi
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsDao: NewsDao,
    private val newsApi: NewsApi
) : NewsRepository {

    override suspend fun saveNews(news: List<NewsBlock>) =
        newsDao.insert(news.map { it.toEntity() })

    override suspend fun deleteAll() =
        newsDao.deleteAll()

    override fun getNewsFromDb(startPosition: Int, loadSize: Int): List<NewsBlock> =
        newsDao.select(startPosition, loadSize)
            .map { it.toModel() }

    override suspend fun getNewsFromServer(): List<NewsBlock> =
        newsApi.getNews().list
            .map { it.toModel() }

    override suspend fun isDatabaseEmpty(): Boolean =
        newsDao.countNews() == 0

    private fun NewsBlock.toEntity(): NewsBlockEntity =
        NewsBlockEntity(
            id = id,
            name = name,
            text = text,
            publicationDate = publicationDate
        )

    private fun NewsBlockEntity.toModel(): NewsBlock =
        NewsBlock(
            id = id,
            name = name,
            text = text,
            publicationDate = publicationDate
        )

    private fun NewsBlockResponse.toModel(): NewsBlock =
        NewsBlock(
            id = id,
            name = name,
            text = text,
            publicationDate = publicationDate.milliseconds
        )

}