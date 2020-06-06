package com.example.tinkoffnewsmvp.utils.logger

import android.util.Log
import com.example.tinkoffnewsmvp.BuildConfig
import java.net.UnknownHostException

fun Any.logD(tag: String? = null, message: String = "", throwable: Throwable? = null) {
    try {
        if (BuildConfig.DEBUG) {
            val logTag = getTag(tag)
            throwable?.printUnknownHostException(logTag)
            val maxLogSize = 1000
            message.lines().forEach { messageLine ->
                for (i in 0..messageLine.length / maxLogSize) {
                    val start = i * maxLogSize
                    var end = (i + 1) * maxLogSize
                    end = if (end > messageLine.length) messageLine.length else end
                    Log.i(logTag, messageLine.substring(start, end), throwable)
                }
            }
        }
    } catch (e: Throwable) {
        //ignore
    }
}

internal fun Throwable.printUnknownHostException(tag: String) {
    if (this is UnknownHostException) {
        Log.e(tag, "UnknownHostException: $message")
    }
}

fun Any.getTag(tag: String? = null): String =
    tag ?: javaClass.simpleName.takeIf { it.isNotEmpty() } ?: "debug"