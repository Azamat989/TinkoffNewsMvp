package com.example.tinkoffnewsmvp.news_details.dependencies

import com.example.tinkoffnewsmvp.core_ui.error.handler.dependencies.UiErrorHandlerModule
import com.example.tinkoffnewsmvp.news_details.*
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