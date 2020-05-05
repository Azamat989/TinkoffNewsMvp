package com.example.tinkoffnewsmvp.core_ui.utils

inline fun consume(action: () -> Unit): Boolean {
    action()
    return true
}

inline fun consumeIf(consume: Boolean, action: () -> Unit): Boolean {
    if (consume) action()
    return consume
}