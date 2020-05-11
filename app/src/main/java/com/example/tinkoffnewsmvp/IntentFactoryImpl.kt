package com.example.tinkoffnewsmvp

import com.example.tinkoffnewsmvp.core_ui.factory.IntentFactory
import com.example.tinkoffnewsmvp.core_ui.factory.creator.MainActivityIntentCreator
import com.example.tinkoffnewsmvp.core_ui.factory.creator.NewsDetailsIntentCreator
import com.example.tinkoffnewsmvp.news.MainActivityIntentCreatorImpl
import com.example.tinkoffnewsmvp.news_details.NewsDetailsIntentCreatorImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IntentFactoryImpl @Inject constructor() : IntentFactory,
    MainActivityIntentCreator by MainActivityIntentCreatorImpl(),
    NewsDetailsIntentCreator by NewsDetailsIntentCreatorImpl()