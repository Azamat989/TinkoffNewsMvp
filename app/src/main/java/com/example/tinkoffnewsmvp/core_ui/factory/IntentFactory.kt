package com.example.tinkoffnewsmvp.core_ui.factory

import com.example.tinkoffnewsmvp.core_ui.factory.creator.MainActivityIntentCreator
import com.example.tinkoffnewsmvp.core_ui.factory.creator.NewsDetailsIntentCreator

interface IntentFactory :
    MainActivityIntentCreator,
    NewsDetailsIntentCreator