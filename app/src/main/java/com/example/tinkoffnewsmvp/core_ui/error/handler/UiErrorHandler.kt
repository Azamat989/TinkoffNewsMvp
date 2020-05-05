package com.example.tinkoffnewsmvp.core_ui.error.handler

import com.example.tinkoffnewsmvp.core_ui.CommonErrorView
import com.example.tinkoffnewsmvp.core_ui.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.utils.logger.logD
import com.example.tinkoffnewsmvp.utils.takeIfNotBlank
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