package com.example.tinkoffnewsmvp.dependencies.repository

import com.example.tinkoffnewsmvp.NewsRepositoryImpl
import com.example.tinkoffnewsmvp.repository.news.NewsRepository
import dagger.Binds
import dagger.Module

@Module
interface NewsRepositoryModule {

    @Binds
    fun bindNewsRepository(impl: NewsRepositoryImpl): NewsRepository

}