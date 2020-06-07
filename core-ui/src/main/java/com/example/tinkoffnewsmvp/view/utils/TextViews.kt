package com.example.tinkoffnewsmvp.view.utils

import android.widget.TextView
import androidx.annotation.FontRes
import com.example.tinkoffnewsmvp.getFont

fun TextView.setFont(@FontRes font: Int) {
    typeface = context.getFont(font)
}