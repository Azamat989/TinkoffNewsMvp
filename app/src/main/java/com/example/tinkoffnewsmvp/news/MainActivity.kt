package com.example.tinkoffnewsmvp.news

import android.content.Context
import android.content.Intent
import com.example.tinkoffnewsmvp.R
import com.example.tinkoffnewsmvp.base.mvp.SimpleActivity
import com.example.tinkoffnewsmvp.createIntent

fun Context.createMainActivityIntent(): Intent =
    createIntent<MainActivity>()

class MainActivity : SimpleActivity<MainActivityPresenter>() {

    override fun getLayout(): Int = R.layout.activity_main

}