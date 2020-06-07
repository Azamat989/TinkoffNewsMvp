package com.example.tinkoffnewsmvp

import android.content.Context
import android.content.Intent
import com.example.tinkoffnewsmvp.factory.creator.NewsDetailsIntentCreator

class NewsDetailsIntentCreatorImpl : NewsDetailsIntentCreator {

    override fun createNewsDetailsIntent(context: Context, newsId: String): Intent =
        context.createNewsDetailsIntent(newsId)

}