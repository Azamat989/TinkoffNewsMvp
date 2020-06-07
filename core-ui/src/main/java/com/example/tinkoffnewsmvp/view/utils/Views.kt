package com.example.tinkoffnewsmvp.view.utils

import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.tinkoffnewsmvp.forEach

const val TRANSPARENT_ALPHA = 0f
const val OPAQUE_ALPHA = 1f
private const val DISABLED_ALPHA = 0.4f
private const val ENABLED_ALPHA = 1f

fun View.isVisible(): Boolean =
    visibility == View.VISIBLE

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.hideKeyboard() {
    val inputMethodManager =
        context.applicationContext.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

fun View.setShown(visible: Boolean) {
    if (visible) show() else hide()
}

fun View.setVisible(visible: Boolean) {
    if (visible) show() else invisible()
}

fun View.setDisabledAlpha(isDisabled: Boolean) {
    alpha = if (isDisabled) DISABLED_ALPHA else ENABLED_ALPHA
}

fun View.makeTransparent() {
    alpha = TRANSPARENT_ALPHA
}

fun View.makeOpaque() {
    alpha = OPAQUE_ALPHA
}

private fun View.setClicksEnabled(enabled: Boolean) {
    isEnabled = enabled
    if (this is ViewGroup) forEach { it.setClicksEnabled(enabled) }
}