package com.example.tinkoffnewsmvp.factory

import com.example.tinkoffnewsmvp.factory.creator.MainActivityIntentCreator
import com.example.tinkoffnewsmvp.factory.creator.NewsDetailsIntentCreator
import com.example.tinkoffnewsmvp.factory.creator.SplashIntentCreator

interface IntentFactory :
    SplashIntentCreator,
    MainActivityIntentCreator,
    NewsDetailsIntentCreator