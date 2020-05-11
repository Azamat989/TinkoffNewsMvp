package com.example.tinkoffnewsmvp.dependencies

import com.example.tinkoffnewsmvp.news.dependencies.MainActivityInjectionModule
import com.example.tinkoffnewsmvp.news_details.dependencies.NewsDetailsInjectionModule
import dagger.Module

@Module(
    includes = [
        MainActivityInjectionModule::class,
        NewsDetailsInjectionModule::class
    ]
)
interface InjectionModule