package com.example.tinkoffnewsmvp.splash

import com.example.tinkoffnewsmvp.core.repository.news.NewsRepository
import com.example.tinkoffnewsmvp.core_ui.dependencies.ActivityScope
import javax.inject.Inject

interface SplashInteractor {

    suspend fun uploadNewsAndSave()

}

@ActivityScope
class SplashInteractorImpl @Inject constructor(
    private val repository: NewsRepository
) : SplashInteractor {

    override suspend fun uploadNewsAndSave() {
        if (repository.isDatabaseEmpty()) {
            val news = repository.getNewsFromServer()
            repository.saveNews(news)
        }
    }

}