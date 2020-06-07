package com.example.tinkoffnewsmvp.dependencies

import com.example.tinkoffnewsmvp.*
import com.example.tinkoffnewsmvp.error.handler.dependencies.UiErrorHandlerModule
import dagger.Binds
import dagger.Module

@Module(includes = [UiErrorHandlerModule::class])
interface NewsDetailsModule {

    @Binds
    fun bindPresenter(impl: NewsDetailsPresenterImpl): NewsDetailsPresenter

    @Binds
    fun bindViewPresenter(impl: NewsDetailsPresenterImpl): NewsDetailsView.Presenter

    @Binds
    fun bindView(impl: NewsDetailsViewImpl): NewsDetailsView

    @Binds
    fun bindInteractor(impl: NewsDetailsInteractorImpl): NewsDetailsInteractor

}