package com.example.tinkoffnewsmvp.core_ui.factory

import com.example.tinkoffnewsmvp.core_ui.factory.creator.MainActivityIntentCreator
import com.example.tinkoffnewsmvp.core_ui.factory.creator.NewsDetailsIntentCreator
import com.example.tinkoffnewsmvp.core_ui.factory.creator.SplashIntentCreator

interface IntentFactory :
    SplashIntentCreator,
    MainActivityIntentCreator,
    NewsDetailsIntentCreator