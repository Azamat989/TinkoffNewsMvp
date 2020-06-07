package com.example.tinkoffnewsmvp

import android.content.Intent
import android.net.Uri

fun Uri.toIntent(): Intent =
    Intent(Intent.ACTION_VIEW, this)