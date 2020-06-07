package com.example.tinkoffnewsmvp.dependencies

import com.example.tinkoffnewsmvp.*
import com.example.tinkoffnewsmvp.error.handler.dependencies.UiErrorHandlerModule
import com.example.tinkoffnewsmvp.paging.NewsSourceFactory
import com.example.tinkoffnewsmvp.paging.NewsSourceFactoryImpl
import com.example.tinkoffnewsmvp.router.MainActivityRouter
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        MainActivityProvidesModule::class,
        UiErrorHandlerModule::class
    ]
)
interface MainActivityModule {

    @Binds
    fun bindPresenter(impl: MainActivityPresenterImpl): MainActivityPresenter

    @Binds
    fun bindViewPresenter(impl: MainActivityPresenterImpl): MainView.Presenter

    @Binds
    fun bindRouter(impl: MainActivityRouter): MainActivityPresenter.Router

    @Binds
    fun bindInteractor(impl: NewsInteractorImpl): NewsInteractor

    @Binds
    fun bindView(impl: MainViewImpl): MainView

    @Binds
    fun bindNewsSourceFactory(impl: NewsSourceFactoryImpl): NewsSourceFactory

}