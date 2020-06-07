package com.example.tinkoffnewsmvp

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.*
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

@ColorInt
fun Context.getResColor(@ColorRes resId: Int): Int =
    ContextCompat.getColor(this, resId)

fun Context.getResDrawable(@DrawableRes id: Int): Drawable =
    checkNotNull(ContextCompat.getDrawable(this, id))

fun Context.getFont(@FontRes fontId: Int): Typeface =
    checkNotNull(ResourcesCompat.getFont(this, fontId))