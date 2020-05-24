package com.example.tinkoffnewsmvp.splash

import android.content.Context
import android.content.Intent
import com.example.tinkoffnewsmvp.core_ui.factory.creator.SplashIntentCreator
import com.example.tinkoffnewsmvp.utils.createIntent

class SplashIntentCreatorImpl : SplashIntentCreator {

    override fun create(context: Context): Intent = context.createIntent<SplashActivity>()

}