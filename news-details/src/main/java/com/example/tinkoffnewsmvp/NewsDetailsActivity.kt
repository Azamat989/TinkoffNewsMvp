package com.example.tinkoffnewsmvp

import android.content.Context
import android.content.Intent
import com.example.tinkoffnewsmvp.base.mvp.SimpleActivity

const val EXTRA_NEWS_ID = "EXTRA_NEWS_ID"

fun Context.createNewsDetailsIntent(newsId: String): Intent =
    createIntent<NewsDetailsActivity>()
        .putExtra(EXTRA_NEWS_ID, newsId)

class NewsDetailsActivity : SimpleActivity<NewsDetailsPresenter>(), NewsDetailsPresenter.Router {

    override fun getLayout(): Int = R.layout.activity_news_details

    fun getExtraNewsId(): String? =
        intent.getStringExtra(EXTRA_NEWS_ID)

}
