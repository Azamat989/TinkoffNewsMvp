package com.example.tinkoffnewsmvp.news.paging

import android.util.Log
import androidx.paging.PositionalDataSource
import com.example.tinkoffnewsmvp.core.dto.news.NewsBlock
import com.example.tinkoffnewsmvp.core.repository.news.NewsRepository

class NewsPositionalDataSource(
    private val newsRepository: NewsRepository
) : PositionalDataSource<NewsBlock>() {

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<NewsBlock>) {
        Log.d(
            TAG,
            "loadRange, startPosition = ${params.startPosition} loadSize = ${params.loadSize}"
        )

        val result = newsRepository.getNewsFromDb(params.startPosition, params.loadSize)
        callback.onResult(result)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<NewsBlock>) {
        Log.d(
            TAG, "loadInitial, requestedStartPosition = ${params.requestedStartPosition} " +
                    "requestedLoadSize = ${params.requestedLoadSize}"
        )

        val result = newsRepository.getNewsFromDb(params.requestedStartPosition, params.requestedLoadSize)
        callback.onResult(result, params.requestedStartPosition)
    }

    companion object {
        const val TAG = "PositionalDataSource"
    }
}