package com.example.tinkoffnewsmvp

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.tinkoffnewsmvp.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.dto.news.NewsBlock
import com.example.tinkoffnewsmvp.paging.NewsSourceFactory
import com.example.tinkoffnewsmvp.repository.news.NewsRepository
import javax.inject.Inject

const val LIST_SIZE = 20
const val PREFETCH_DISTANCE = LIST_SIZE / 2
const val INITIAL_LOAD_SIZE = LIST_SIZE * 2

interface NewsInteractor {

    suspend fun refreshNews()
    suspend fun isDatabaseEmpty(): Boolean
    suspend fun getNewsPagedList(): LiveData<PagedList<NewsBlock>>

}

@ActivityScope
class NewsInteractorImpl @Inject constructor(
    private val newsRepository: NewsRepository,
    private val newsSourceFactory: NewsSourceFactory
) : NewsInteractor {

    override suspend fun refreshNews() {
        val news = newsRepository.getNewsFromServer()
        newsRepository.deleteAll()
        newsRepository.saveNews(news)
    }

    override suspend fun isDatabaseEmpty(): Boolean =
        newsRepository.isDatabaseEmpty()

    @Suppress("UNCHECKED_CAST")
    override suspend fun getNewsPagedList(): LiveData<PagedList<NewsBlock>> =
        LivePagedListBuilder(
            newsSourceFactory as DataSource.Factory<Int, NewsBlock>,
            getPagedListConfig()
        )
            .build()

    private fun getPagedListConfig(): PagedList.Config =
        PagedList.Config.Builder()
            .setInitialLoadSizeHint(INITIAL_LOAD_SIZE)
            .setPrefetchDistance(PREFETCH_DISTANCE)
            .setPageSize(LIST_SIZE)
            .setMaxSize(Int.MAX_VALUE)
            .setEnablePlaceholders(false)
            .build()

}