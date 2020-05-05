package com.example.tinkoffnewsmvp.news

import android.content.Context
import android.content.Intent
import com.example.tinkoffnewsmvp.core_ui.factory.creator.MainActivityCreator
import com.example.tinkoffnewsmvp.utils.createIntent

class MainActivityCreatorImpl : MainActivityCreator {

    override fun create(context: Context): Intent =
        context.createIntent<MainActivity>()

}