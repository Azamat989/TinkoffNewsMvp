package com.example.tinkoffnewsmvp.dependencies.repository

import com.example.tinkoffnewsmvp.core.repository.news_content.NewsContentRepository
import com.example.tinkoffnewsmvp.data.repository.NewsContentRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface NewsContentRepositoryModule {

    @Binds
    fun bindRepository(impl: NewsContentRepositoryImpl): NewsContentRepository

}