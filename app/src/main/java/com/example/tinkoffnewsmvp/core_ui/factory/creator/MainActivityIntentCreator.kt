package com.example.tinkoffnewsmvp.core_ui.factory.creator

import android.content.Context
import android.content.Intent

interface MainActivityIntentCreator {

    fun createMainActivityIntent(context: Context): Intent

}