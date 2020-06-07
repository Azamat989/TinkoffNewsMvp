package com.example.tinkoffnewsmvp.dependencies

import com.example.tinkoffnewsmvp.SplashActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [SplashComponent::class])
interface SplashInjectionModule {

    @Binds
    @IntoMap
    @ClassKey(SplashActivity::class)
    fun bindFactory(factory: SplashComponent.Factory): AndroidInjector.Factory<*>

}