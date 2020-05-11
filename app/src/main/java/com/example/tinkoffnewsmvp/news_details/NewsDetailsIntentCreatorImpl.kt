package com.example.tinkoffnewsmvp.news_details

import android.content.Context
import android.content.Intent
import com.example.tinkoffnewsmvp.core_ui.factory.creator.NewsDetailsIntentCreator

class NewsDetailsIntentCreatorImpl : NewsDetailsIntentCreator {

    override fun createNewsDetailsIntent(context: Context, newsId: String): Intent =
        context.createNewsDetailsIntent(newsId)

}