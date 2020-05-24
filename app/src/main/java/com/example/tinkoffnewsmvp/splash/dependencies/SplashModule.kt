package com.example.tinkoffnewsmvp.splash.dependencies

import com.example.tinkoffnewsmvp.core_ui.error.handler.dependencies.UiErrorHandlerModule
import com.example.tinkoffnewsmvp.splash.*
import dagger.Binds
import dagger.Module

@Module(includes = [UiErrorHandlerModule::class])
interface SplashModule {

    @Binds
    fun bindPresenter(impl: SplashPresenterImpl): SplashPresenter

    @Binds
    fun bindRouter(impl: SplashRouterImpl): SplashPresenter.Router

    @Binds
    fun bindView(impl: SplashViewImpl): SplashView

    @Binds
    fun bind(impl: SplashInteractorImpl): SplashInteractor

}