package com.example.tinkoffnewsmvp.core_ui.view.utils

import android.view.View
import android.widget.TextView
import androidx.annotation.FontRes
import androidx.annotation.StringRes
import com.example.tinkoffnewsmvp.utils.getFont
import com.example.tinkoffnewsmvp.utils.toHtml

fun TextView.showText(@StringRes textId: Int?, invisibleIfEmpty: Boolean = false) {
    showText(
        textId?.let { context.getString(it) },
        invisibleIfEmpty
    )
}

fun TextView.showText(text: CharSequence?, invisibleIfEmpty: Boolean = false) {
    visibility = when {
        !text.isNullOrEmpty() -> View.VISIBLE
        invisibleIfEmpty -> View.INVISIBLE
        else -> View.GONE
    }
    setText(text)
}

fun TextView.showHtml(html: String?) {
    if (html.isNullOrEmpty()) {
        hide()
    } else {
        show()
        setHtml(html)
    }
}

fun TextView.setHtml(html: String) {
    setText(html.toHtml(), TextView.BufferType.SPANNABLE)
}

fun TextView.setFont(@FontRes font: Int) {
    typeface = context.getFont(font)
}