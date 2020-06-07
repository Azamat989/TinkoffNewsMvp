package com.example.tinkoffnewsmvp.utils

import android.content.Context
import kotlinx.android.extensions.LayoutContainer

val LayoutContainer.context: Context
    get() = checkNotNull(containerView).context