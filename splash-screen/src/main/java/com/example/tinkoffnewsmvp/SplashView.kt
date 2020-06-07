package com.example.tinkoffnewsmvp

import android.view.ViewGroup
import com.example.tinkoffnewsmvp.base.back.BackListener
import com.example.tinkoffnewsmvp.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.view.CommonErrorView
import com.example.tinkoffnewsmvp.view.CommonErrorViewImpl
import com.example.tinkoffnewsmvp.view.utils.OPAQUE_ALPHA
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_splash.view.*
import javax.inject.Inject

interface SplashView : CommonErrorView {

    fun showLoading()

    interface Presenter : BackListener

}

private const val PROGRESS_DELAY = 5_000L
private const val PROGRESS_ALPHA_DURATION = 166L

@ActivityScope
class SplashViewImpl @Inject constructor(
    override val containerView: ViewGroup
) : LayoutContainer,
    SplashView,
    CommonErrorView by CommonErrorViewImpl(containerView.context) {

    override fun showLoading() {
        containerView.splashProgress.alpha = 0f
        animateProgress()
    }

    private fun animateProgress() {
        containerView.splashProgress
            .animate()
            .alpha(OPAQUE_ALPHA)
            .setDuration(PROGRESS_ALPHA_DURATION)
            .setStartDelay(PROGRESS_DELAY)
            .start()
    }

}