package com.example.tinkoffnewsmvp.splash.dependencies

import android.app.Activity
import android.view.ViewGroup
import com.example.tinkoffnewsmvp.dependencies.ActivityScope
import com.example.tinkoffnewsmvp.splash.SplashActivity
import com.example.tinkoffnewsmvp.utils.getContentView
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector

@ActivityScope
@Subcomponent(modules = [SplashModule::class])
interface SplashComponent : AndroidInjector<SplashActivity> {

    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<SplashActivity> {

        final override fun create(instance: SplashActivity): AndroidInjector<SplashActivity> =
            create(
                instance,
                instance.getContentView()
            )


        abstract fun create(
            @BindsInstance activity: Activity,
            @BindsInstance viewGroup: ViewGroup
        ): AndroidInjector<SplashActivity>

    }

}