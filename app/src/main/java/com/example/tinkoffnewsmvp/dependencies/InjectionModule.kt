package com.example.tinkoffnewsmvp.dependencies

import dagger.Module

@Module(
    includes = [
        SplashInjectionModule::class,
        MainActivityInjectionModule::class,
        NewsDetailsInjectionModule::class
    ]
)
interface InjectionModule