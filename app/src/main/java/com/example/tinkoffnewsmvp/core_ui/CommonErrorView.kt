package com.example.tinkoffnewsmvp.core_ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.example.tinkoffnewsmvp.core_ui.error.showError
import com.example.tinkoffnewsmvp.utils.isDead

interface CommonErrorView {

    fun showCommonError(
        error: Throwable? = null,
        @StringRes titleResId: Int? = null, title: String? = null,
        @StringRes messageResId: Int? = null, message: String? = null,
        onAction: (() -> Unit)? = null,
        onCancel: () -> Unit = {}
    )

    fun hideCommonError()

}

class CommonErrorViewImpl(private val context: Context) : CommonErrorView {

    private var dialog: AlertDialog? = null

    override fun showCommonError(
        error: Throwable?,
        titleResId: Int?,
        title: String?,
        messageResId: Int?,
        message: String?,
        onAction: (() -> Unit)?,
        onCancel: () -> Unit
    ) {
        showDialog(
            error,
            titleResId?.let(context::getString) ?: title,
            messageResId?.let(context::getString) ?: message,
            onAction,
            onCancel
        )
    }

    override fun hideCommonError() {
        dialog?.dismiss()
        dialog = null
    }

    private fun showDialog(
        error: Throwable?,
        title: String?,
        message: String?,
        onAction: (() -> Unit)?,
        onCancel: () -> Unit
    ) {
        if (context.isDead()) return
        dialog?.dismiss()
        dialog = context.showError(
            error = error,
            title = title,
            onAction = onAction,
            onCancel = onCancel
        )
    }

}
