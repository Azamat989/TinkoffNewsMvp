package com.example.tinkoffnewsmvp.news

import android.content.Context
import android.content.Intent
import com.example.tinkoffnewsmvp.createIntent
import com.example.tinkoffnewsmvp.factory.creator.MainActivityIntentCreator

class MainActivityIntentCreatorImpl : MainActivityIntentCreator {

    override fun createMainActivityIntent(context: Context): Intent =
        context.createIntent<MainActivity>()

}