package com.example.tinkoffnewsmvp.core_ui.utils

import android.content.Context
import kotlinx.android.extensions.LayoutContainer

val LayoutContainer.context: Context
    get() = checkNotNull(containerView).context