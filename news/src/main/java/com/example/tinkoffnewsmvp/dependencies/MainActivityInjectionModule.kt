package com.example.tinkoffnewsmvp.dependencies

import com.example.tinkoffnewsmvp.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivityComponent::class])
interface MainActivityInjectionModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    fun bindMainActivityFactory(factory: MainActivityComponent.Factory): AndroidInjector.Factory<*>
}