package com.example.tinkoffnewsmvp

import android.content.Context
import android.content.Intent
import com.example.tinkoffnewsmvp.base.mvp.SimpleActivity

fun Context.createMainActivityIntent(): Intent =
    createIntent<MainActivity>()

class MainActivity : SimpleActivity<MainActivityPresenter>() {

    override fun getLayout(): Int = R.layout.activity_main

}