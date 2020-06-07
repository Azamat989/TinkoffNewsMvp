package com.example.tinkoffnewsmvp.splash

import android.content.Context
import android.content.Intent
import com.example.tinkoffnewsmvp.createIntent
import com.example.tinkoffnewsmvp.factory.creator.SplashIntentCreator

class SplashIntentCreatorImpl : SplashIntentCreator {

    override fun create(context: Context): Intent = context.createIntent<SplashActivity>()

}