package com.example.tinkoffnewsmvp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutId: Int, attach: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutId, this, attach)

inline fun ViewGroup.forEachIndexed(action: (Int, View) -> Unit) {
    (0 until childCount).forEach { index ->
        action(index, getChildAt(index))
    }
}

inline fun ViewGroup.forEach(action: (View) -> Unit) {
    forEachIndexed { _, view -> action(view) }
}