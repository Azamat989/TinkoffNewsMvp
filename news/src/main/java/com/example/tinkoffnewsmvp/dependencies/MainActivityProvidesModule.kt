package com.example.tinkoffnewsmvp.dependencies

import android.view.ViewGroup
import com.example.tinkoffnewsmvp.MainActivityPresenterImpl
import com.example.tinkoffnewsmvp.adapter.NewsAdapter
import com.example.tinkoffnewsmvp.view.SwipeRefreshView
import com.example.tinkoffnewsmvp.view.SwipeRefreshViewImpl
import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.activity_main.view.*

@Module
class MainActivityProvidesModule {

    @ActivityScope
    @Provides
    fun provideSwipeRefreshView(
        view: ViewGroup,
        presenter: MainActivityPresenterImpl
    ): SwipeRefreshView =
        SwipeRefreshViewImpl(view.newsSwipeToRefreshLayout, presenter)

    @ActivityScope
    @Provides
    fun provideAdapter(callback: MainActivityPresenterImpl): NewsAdapter = NewsAdapter(callback)

}