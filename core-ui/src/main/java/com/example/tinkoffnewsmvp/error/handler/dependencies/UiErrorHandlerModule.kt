package com.example.tinkoffnewsmvp.error.handler.dependencies

import com.example.tinkoffnewsmvp.error.handler.UiErrorHandler
import com.example.tinkoffnewsmvp.error.handler.UiErrorHandlerImpl
import dagger.Binds
import dagger.Module

@Module
interface UiErrorHandlerModule {

    @Binds
    fun bindUiErrorHandler(impl: UiErrorHandlerImpl): UiErrorHandler

}