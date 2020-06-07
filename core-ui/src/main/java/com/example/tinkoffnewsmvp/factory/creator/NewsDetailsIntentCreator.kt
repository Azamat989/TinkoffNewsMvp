package com.example.tinkoffnewsmvp.factory.creator

import android.content.Context
import android.content.Intent

interface NewsDetailsIntentCreator {

    fun createNewsDetailsIntent(context: Context, newsId: String): Intent

}