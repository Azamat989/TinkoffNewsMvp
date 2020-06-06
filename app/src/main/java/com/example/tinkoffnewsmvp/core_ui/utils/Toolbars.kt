package com.example.tinkoffnewsmvp.core_ui.utils

import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar

fun Toolbar.baseInit(
    @StringRes titleResId: Int = 0,
    onBackListener: (() -> Unit)? = null
) {
    val title = if (titleResId != 0) context.getString(titleResId) else null
    baseInit(title, onBackListener)
}

fun Toolbar.baseInit(
    title: String?,
    onBackListener: (() -> Unit)? = null
) {
    setTitle(title)
    if (onBackListener == null) {
        navigationIcon = null
    } else {
        setNavigationOnClickListener { onBackListener() }
    }
}