package com.example.tinkoffnewsmvp.dependencies

import com.example.tinkoffnewsmvp.news.dependencies.MainActivityInjectionModule
import dagger.Module

@Module(
    includes = [MainActivityInjectionModule::class]
)
interface InjectionModule