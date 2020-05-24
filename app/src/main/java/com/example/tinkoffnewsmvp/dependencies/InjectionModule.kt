package com.example.tinkoffnewsmvp.dependencies

import com.example.tinkoffnewsmvp.news.dependencies.MainActivityInjectionModule
import com.example.tinkoffnewsmvp.news_details.dependencies.NewsDetailsInjectionModule
import com.example.tinkoffnewsmvp.splash.dependencies.SplashInjectionModule
import dagger.Module

@Module(
    includes = [
        SplashInjectionModule::class,
        MainActivityInjectionModule::class,
        NewsDetailsInjectionModule::class
    ]
)
interface InjectionModule