package com.example.tinkoffnewsmvp.base.mvp

import com.example.tinkoffnewsmvp.base.BaseRouter
import com.example.tinkoffnewsmvp.base.back.BackListener
import com.example.tinkoffnewsmvp.base.coroutines.ProgressCoroutineJobDelegate
import com.example.tinkoffnewsmvp.base.coroutines.ProgressCoroutineJobDelegateImpl
import com.example.tinkoffnewsmvp.error.handler.UiErrorHandler
import com.example.tinkoffnewsmvp.view.CommonErrorView
import dagger.Lazy
import javax.inject.Inject

abstract class BasePresenter<R : BaseRouter, V : CommonErrorView> :
    LifecyclePresenter,
    BackListener,
    ProgressCoroutineJobDelegate by ProgressCoroutineJobDelegateImpl() {

    @Inject
    lateinit var router: R

    @Inject
    lateinit var lazyView: Lazy<V>

    @Inject
    lateinit var errorHandler: UiErrorHandler

    protected val view: V
        get() = lazyView.get()

    override fun init() {
        initializeCoroutineJob()
    }

    override fun start() {
        initializeCoroutineJob()
        lazyView.get()
        onStart()
    }

    override fun stop() {
        view.hideCommonError()
        cancelCoroutineJob()
        onStop()
    }

    override fun destroy() {
        cancelCoroutineJob()
    }

    override fun onBackPressed() {
        router.finish()
    }

    protected open fun onStart() {}

    protected open fun onStop() {}

    protected fun Throwable.handleWithDialog(message: String? = "", okHandler: () -> Unit = {}) {
        errorHandler.handleWithDialog(view, this, message, okHandler)
    }

}
