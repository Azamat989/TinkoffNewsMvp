package com.example.tinkoffnewsmvp.paging

import androidx.paging.DataSource
import com.example.tinkoffnewsmvp.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.dto.news.NewsBlock
import com.example.tinkoffnewsmvp.repository.news.NewsRepository
import javax.inject.Inject

interface NewsSourceFactory

@ActivityScope
class NewsSourceFactoryImpl @Inject constructor(
    private val newsRepository: NewsRepository
) : DataSource.Factory<Int, NewsBlock>(), NewsSourceFactory {

    override fun create(): DataSource<Int, NewsBlock> =
        NewsPositionalDataSource(newsRepository)
}