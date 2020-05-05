package com.example.tinkoffnewsmvp.core_ui.error

import android.content.Context
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.example.tinkoffnewsmvp.R
import com.example.tinkoffnewsmvp.core_ui.utils.showAlertDialog

fun Context.showError(
    error: Throwable? = null,
    title: String? = null,
    @StringRes actionTextRes: Int = R.string.common_repeat_button,
    onAction: (() -> Unit)? = null,
    @StringRes cancelTextRes: Int = R.string.common_close_button,
    onCancel: () -> Unit = {}
): AlertDialog =
    showAlertDialog {
        setTitle(title ?: getString(R.string.common_error_title))
        setMessage(error?.message)
        if (onAction != null) setPositiveButton(actionTextRes) { _, _ -> onAction() }
        setNegativeButton(cancelTextRes) { _, _ -> onCancel() }
        setCancelable(false)
    }

private fun Context.getDefaultErrorMessage(error: Throwable?): ErrorMessage =
    ErrorMessage(getString(R.string.common_operation_failed), error)