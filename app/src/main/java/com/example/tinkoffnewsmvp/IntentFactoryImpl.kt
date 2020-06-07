package com.example.tinkoffnewsmvp

import com.example.tinkoffnewsmvp.factory.IntentFactory
import com.example.tinkoffnewsmvp.factory.creator.MainActivityIntentCreator
import com.example.tinkoffnewsmvp.factory.creator.NewsDetailsIntentCreator
import com.example.tinkoffnewsmvp.factory.creator.SplashIntentCreator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IntentFactoryImpl @Inject constructor() : IntentFactory,
    SplashIntentCreator by SplashIntentCreatorImpl(),
    MainActivityIntentCreator by MainActivityIntentCreatorImpl(),
    NewsDetailsIntentCreator by NewsDetailsIntentCreatorImpl()