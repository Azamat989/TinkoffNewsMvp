package com.example.tinkoffnewsmvp.news.router

import android.app.Activity
import com.example.tinkoffnewsmvp.core_ui.factory.IntentFactory
import com.example.tinkoffnewsmvp.news.MainActivityPresenter
import javax.inject.Inject

class MainActivityRouter @Inject constructor(
    private val activity: Activity,
    private val intentFactory: IntentFactory
) : MainActivityPresenter.Router {

    override fun moveToNewsDetails(newsId: String) {
        val intent = intentFactory.createNewsDetailsIntent(activity, newsId)
        activity.startActivity(intent)
    }

    override fun finish() {
        activity.finish()
    }

}