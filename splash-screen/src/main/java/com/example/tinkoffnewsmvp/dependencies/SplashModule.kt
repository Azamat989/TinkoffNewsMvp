package com.example.tinkoffnewsmvp.dependencies

import com.example.tinkoffnewsmvp.*
import com.example.tinkoffnewsmvp.error.handler.dependencies.UiErrorHandlerModule
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