package com.example.tinkoffnewsmvp.news.dependencies

import android.view.ViewGroup
import com.example.tinkoffnewsmvp.core_ui.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.core_ui.view.SwipeRefreshView
import com.example.tinkoffnewsmvp.core_ui.view.SwipeRefreshViewImpl
import com.example.tinkoffnewsmvp.news.MainActivityPresenterImpl
import com.example.tinkoffnewsmvp.news.adapter.NewsAdapter
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