package com.example.tinkoffnewsmvp.core_ui.error.handler.dependencies

import com.example.tinkoffnewsmvp.core_ui.error.handler.UiErrorHandler
import com.example.tinkoffnewsmvp.core_ui.error.handler.UiErrorHandlerImpl
import dagger.Binds
import dagger.Module

@Module
interface UiErrorHandlerModule {

    @Binds
    fun bindUiErrorHandler(impl: UiErrorHandlerImpl): UiErrorHandler

}