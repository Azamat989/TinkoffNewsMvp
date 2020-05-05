package com.example.tinkoffnewsmvp.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.LayoutRes


inline fun <reified T> Context.createIntent() = Intent(this, T::class.java)


fun Context.inflate(@LayoutRes layoutId: Int): View =
    LayoutInflater.from(this).inflate(layoutId, null)

fun Context.findActivity(): Activity? =
    when (this) {
        is Activity -> this
        is ContextWrapper -> baseContext.findActivity()
        else -> {
            throw IllegalArgumentException("Cannot find activity context")
        }
    }

fun Context.isDead(): Boolean =
    findActivity()?.isDestroyed == true