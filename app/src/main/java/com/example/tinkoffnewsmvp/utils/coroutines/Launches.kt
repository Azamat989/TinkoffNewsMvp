package com.example.tinkoffnewsmvp.utils.coroutines

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun CoroutineScope.tryLaunch(
    doOnLaunch: suspend CoroutineScope.() -> Unit,
    doOnError: Throwable.() -> Unit,
    doFinally: (() -> Unit)? = null
): Job =
    launch(
        CoroutineExceptionHandler { _, error ->
            error.doOnError()
        }
    ) {
        supervisorScope { doOnLaunch() }
    }
        .apply {
            doFinally?.let { doFinally ->
                invokeOnCompletion {
                    doFinally()
                }
            }
        }

fun tryBlocking(
    block: suspend () -> Unit,
    doOnError: Throwable.() -> Unit = {}
) {
    runBlocking {
        try {
            block()
        } catch (exception: Exception) {
            exception.checkCancellation()
            exception.doOnError()
        }
    }
}

fun tryGlobalLaunch(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend () -> Unit,
    doOnError: Throwable.() -> Unit
) {
    GlobalScope.launch(context) {
        try {
            block()
        } catch (exception: Exception) {
            exception.checkCancellation()
            exception.doOnError()
        }
    }
}

fun Throwable.checkCancellation() {
    if (this is CancellationException) throw this
}