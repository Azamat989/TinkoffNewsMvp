package com.example.tinkoffnewsmvp.core_ui.factory.creator

import android.content.Context
import android.content.Intent

interface SplashIntentCreator {

    fun create(context: Context): Intent

}