package com.example.tinkoffnewsmvp.news

import android.content.Context
import android.content.Intent
import com.example.tinkoffnewsmvp.R
import com.example.tinkoffnewsmvp.core_ui.base.mvp.SimpleActivity
import com.example.tinkoffnewsmvp.utils.createIntent

fun Context.createMainActivityIntent(): Intent =
    createIntent<MainActivity>()

class MainActivity : SimpleActivity<MainActivityPresenter>(),
    MainActivityPresenter.Router {

    override fun getLayout(): Int = R.layout.activity_main

}