package com.example.tinkoffnewsmvp.news.dependencies

import android.app.Activity
import android.view.ViewGroup
import com.example.tinkoffnewsmvp.core_ui.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.core_ui.error.handler.dependencies.UiErrorHandlerModule
import com.example.tinkoffnewsmvp.core_ui.utils.getContentView
import com.example.tinkoffnewsmvp.news.MainActivity
import com.example.tinkoffnewsmvp.news.MainActivityPresenter
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<MainActivity> {

        final override fun create(instance: MainActivity): AndroidInjector<MainActivity> =
            create(
                instance,
                instance,
                instance.getContentView()
            )

        abstract fun create(
            @BindsInstance activity: Activity,
            @BindsInstance router: MainActivityPresenter.Router,
            @BindsInstance viewGroup: ViewGroup
        ): AndroidInjector<MainActivity>

    }

}