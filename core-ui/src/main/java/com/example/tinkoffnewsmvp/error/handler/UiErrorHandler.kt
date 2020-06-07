package com.example.tinkoffnewsmvp.error.handler

import com.example.tinkoffnewsmvp.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.takeIfNotBlank
import com.example.tinkoffnewsmvp.utils.logD
import com.example.tinkoffnewsmvp.view.CommonErrorView
import javax.inject.Inject

interface UiErrorHandler {

    fun handle(error: Throwable, message: String? = "", defaultHandler: () -> Unit = {})

    fun handleWithDialog(
        view: CommonErrorView,
        error: Throwable,
        message: String? = "",
        okHandler: () -> Unit = {}
    )

}

@ActivityScope
class UiErrorHandlerImpl @Inject constructor() : UiErrorHandler {

    override fun handle(error: Throwable, message: String?, defaultHandler: () -> Unit) {
        message?.let { logD(it) }
        defaultHandler()
    }

    override fun handleWithDialog(
        view: CommonErrorView,
        error: Throwable,
        message: String?,
        okHandler: () -> Unit
    ) {
        handle(error, message) {
            view.showCommonError(
                error,
                message = message?.takeIfNotBlank(),
                onCancel = okHandler
            )
        }
    }

}