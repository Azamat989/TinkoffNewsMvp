package com.example.tinkoffnewsmvp.splash

import android.app.Activity
import com.example.tinkoffnewsmvp.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.factory.IntentFactory
import javax.inject.Inject

@ActivityScope
class SplashRouterImpl @Inject constructor(
    private val activity: Activity,
    private val intentFactory: IntentFactory
) : SplashPresenter.Router {

    override fun moveToNews() {
        val intent = intentFactory.createMainActivityIntent(activity)
        activity.startActivity(intent)
    }

    override fun finish() {
        activity.finish()
    }

}