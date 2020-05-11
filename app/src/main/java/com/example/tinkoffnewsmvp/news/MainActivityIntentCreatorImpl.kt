package com.example.tinkoffnewsmvp.news

import android.content.Context
import android.content.Intent
import com.example.tinkoffnewsmvp.core_ui.factory.creator.MainActivityIntentCreator
import com.example.tinkoffnewsmvp.utils.createIntent

class MainActivityIntentCreatorImpl : MainActivityIntentCreator {

    override fun createMainActivityIntent(context: Context): Intent =
        context.createIntent<MainActivity>()

}