package com.example.tinkoffnewsmvp

import android.os.Bundle
import android.view.View
import com.example.tinkoffnewsmvp.base.mvp.SimpleActivity

class SplashActivity : SimpleActivity<SplashPresenter>() {

    override fun getLayout(): Int = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        }
    }

}