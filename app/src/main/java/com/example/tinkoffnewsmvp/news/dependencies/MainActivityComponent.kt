package com.example.tinkoffnewsmvp.news.dependencies

import android.app.Activity
import android.view.ViewGroup
import com.example.tinkoffnewsmvp.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.news.MainActivity
import com.example.tinkoffnewsmvp.utils.getContentView
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
                instance.getContentView()
            )

        abstract fun create(
            @BindsInstance activity: Activity,
            @BindsInstance viewGroup: ViewGroup
        ): AndroidInjector<MainActivity>

    }

}