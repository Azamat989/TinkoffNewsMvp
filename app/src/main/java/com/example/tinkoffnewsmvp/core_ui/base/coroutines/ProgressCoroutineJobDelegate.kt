package com.example.tinkoffnewsmvp.core_ui.base.coroutines

import com.example.tinkoffnewsmvp.core_ui.base.progress.Progress
import com.example.tinkoffnewsmvp.core_ui.view.TransparentProgress
import com.example.tinkoffnewsmvp.utils.coroutines.tryLaunch
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var PROGRESS_DELAY = 500L

interface ProgressCoroutineJobDelegate : CoroutineJobDelegate {

    fun Progress.tryLaunch(
        doOnLaunch: suspend CoroutineScope.() -> Unit,
        doOnError: Throwable.() -> Unit,
        doFinally: (() -> Unit)? = null
    ): Job

    fun TransparentProgress.tryLaunch(
        doOnLaunch: suspend CoroutineScope.() -> Unit,
        doOnError: Throwable.() -> Unit,
        doFinally: (() -> Unit)? = null
    ): Job

    fun TransparentProgress.tryLaunchWithProgressDelay(
        doOnLaunch: suspend CoroutineScope.() -> Unit,
        doOnError: Throwable.() -> Unit,
        doFinally: (() -> Unit)? = null
    ): Job

}

class ProgressCoroutineJobDelegateImpl :
    ProgressCoroutineJobDelegate,
    CoroutineJobDelegate by CoroutineJobDelegateImpl() {

    override fun Progress.tryLaunch(
        doOnLaunch: suspend CoroutineScope.() -> Unit,
        doOnError: Throwable.() -> Unit,
        doFinally: (() -> Unit)?
    ): Job =
        tryLaunchWithProgress(
            { showProgress() },
            { hideProgress() },
            doOnLaunch,
            doOnError,
            doFinally
        )

    override fun TransparentProgress.tryLaunch(
        doOnLaunch: suspend CoroutineScope.() -> Unit,
        doOnError: Throwable.() -> Unit,
        doFinally: (() -> Unit)?
    ): Job =
        tryLaunchWithProgress(
            { showTransparentProgress() },
            { hideTransparentProgress() },
            doOnLaunch,
            doOnError,
            doFinally
        )

    override fun TransparentProgress.tryLaunchWithProgressDelay(
        doOnLaunch: suspend CoroutineScope.() -> Unit,
        doOnError: Throwable.() -> Unit,
        doFinally: (() -> Unit)?
    ): Job =
        this@ProgressCoroutineJobDelegateImpl.tryLaunch(
            doOnLaunch = {
                val progress = launch {
                    delay(PROGRESS_DELAY)
                    showTransparentProgress()
                }
                doOnLaunch()
                progress.cancel()
            },
            doOnError = doOnError,
            doFinally = {
                doFinally?.invoke()
                hideTransparentProgress()
            }
        )

    private fun tryLaunchWithProgress(
        show: () -> Unit,
        hide: () -> Unit,
        doOnLaunch: suspend CoroutineScope.() -> Unit,
        doOnError: Throwable.() -> Unit,
        doFinally: (() -> Unit)?
    ): Job =
        tryLaunch(
            doOnLaunch = {
                show()
                doOnLaunch()
            },
            doOnError = doOnError,
            doFinally = {
                doFinally?.invoke()
                hide()
            }
        )

}