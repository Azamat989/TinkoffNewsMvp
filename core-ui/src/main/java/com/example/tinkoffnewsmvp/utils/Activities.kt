package com.example.tinkoffnewsmvp.utils

import android.app.Activity
import android.view.ViewGroup

fun Activity.getContentView(): ViewGroup =
    findViewById(android.R.id.content)