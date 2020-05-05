package com.example.tinkoffnewsmvp.core_ui.factory.creator

import android.content.Context
import android.content.Intent

interface MainActivityCreator {

    fun create(context: Context): Intent

}