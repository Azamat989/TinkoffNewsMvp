package com.example.tinkoffnewsmvp.core_ui.utils

import android.content.Context
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.tinkoffnewsmvp.R
import com.example.tinkoffnewsmvp.core_ui.view.utils.setFont

fun Context.showAlertDialog(
    block: AlertDialog.Builder.() -> Unit = {}
): AlertDialog =
    AlertDialog.Builder(this)
        .apply(block)
        .show()
        .also { it.setRobotoMessage() }

private fun AlertDialog.setRobotoMessage() {
    val messageView = window?.findViewById<TextView>(android.R.id.message) ?: return
    messageView.setFont(R.font.roboto)
}