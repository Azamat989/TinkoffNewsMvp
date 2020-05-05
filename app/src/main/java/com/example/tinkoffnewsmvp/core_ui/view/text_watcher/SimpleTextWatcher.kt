package com.example.tinkoffnewsmvp.core_ui.view.text_watcher

import android.text.Editable
import android.text.TextWatcher

class SimpleTextWatcher(private val callback: (Editable) -> Unit) : TextWatcher {

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        // empty
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        // empty
    }

    override fun afterTextChanged(editable: Editable) {
        callback(editable)
    }

}