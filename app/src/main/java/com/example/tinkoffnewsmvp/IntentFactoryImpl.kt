package com.example.tinkoffnewsmvp

import com.example.tinkoffnewsmvp.core_ui.factory.IntentFactory
import com.example.tinkoffnewsmvp.core_ui.factory.creator.MainActivityCreator
import com.example.tinkoffnewsmvp.news.MainActivityCreatorImpl
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IntentFactoryImpl @Inject constructor() : IntentFactory,
    MainActivityCreator by MainActivityCreatorImpl()