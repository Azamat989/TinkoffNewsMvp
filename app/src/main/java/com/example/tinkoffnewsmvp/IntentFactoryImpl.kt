package com.example.tinkoffnewsmvp

import com.example.tinkoffnewsmvp.factory.IntentFactory
import com.example.tinkoffnewsmvp.factory.creator.MainActivityIntentCreator
import com.example.tinkoffnewsmvp.factory.creator.NewsDetailsIntentCreator
import com.example.tinkoffnewsmvp.factory.creator.SplashIntentCreator
import com.example.tinkoffnewsmvp.news.MainActivityIntentCreatorImpl
import com.example.tinkoffnewsmvp.news_details.NewsDetailsIntentCreatorImpl
import com.example.tinkoffnewsmvp.splash.SplashIntentCreatorImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IntentFactoryImpl @Inject constructor() : IntentFactory,
    SplashIntentCreator by SplashIntentCreatorImpl(),
    MainActivityIntentCreator by MainActivityIntentCreatorImpl(),
    NewsDetailsIntentCreator by NewsDetailsIntentCreatorImpl()