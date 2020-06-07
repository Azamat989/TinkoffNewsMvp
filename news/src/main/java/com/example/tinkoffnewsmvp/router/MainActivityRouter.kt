package com.example.tinkoffnewsmvp.router

import android.app.Activity
import com.example.tinkoffnewsmvp.MainActivityPresenter
import com.example.tinkoffnewsmvp.factory.IntentFactory
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