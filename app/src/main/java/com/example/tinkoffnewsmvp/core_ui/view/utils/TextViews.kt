package com.example.tinkoffnewsmvp.core_ui.view.utils

import android.widget.TextView
import androidx.annotation.FontRes
import com.example.tinkoffnewsmvp.utils.getFont

fun TextView.setFont(@FontRes font: Int) {
    typeface = context.getFont(font)
}