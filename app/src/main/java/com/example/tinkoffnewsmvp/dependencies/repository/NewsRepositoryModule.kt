package com.example.tinkoffnewsmvp.dependencies.repository

import com.example.tinkoffnewsmvp.core.repository.news.NewsRepository
import com.example.tinkoffnewsmvp.data.repository.NewsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface NewsRepositoryModule {

    @Binds
    fun provideNewsRepository(impl: NewsRepositoryImpl): NewsRepository

}