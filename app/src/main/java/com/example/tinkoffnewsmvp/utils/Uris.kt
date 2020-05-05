package com.example.tinkoffnewsmvp.utils

import android.content.Intent
import android.net.Uri

fun Uri.toIntent(): Intent =
    Intent(Intent.ACTION_VIEW, this)