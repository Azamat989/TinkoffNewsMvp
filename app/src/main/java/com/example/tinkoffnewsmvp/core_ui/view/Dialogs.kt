package com.example.tinkoffnewsmvp.core_ui.view

import android.app.Dialog
import android.view.KeyEvent
import com.example.tinkoffnewsmvp.core_ui.utils.consumeIf

inline fun Dialog.setBackListener(crossinline action: Dialog.() -> Unit) {
    setOnKeyListener { _, keyCode, _ ->
        consumeIf(keyCode == KeyEvent.KEYCODE_BACK) {
            action()
        }
    }
}