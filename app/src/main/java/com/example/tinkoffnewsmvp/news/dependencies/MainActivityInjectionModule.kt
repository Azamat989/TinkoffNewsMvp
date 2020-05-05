package com.example.tinkoffnewsmvp.news.dependencies

import com.example.tinkoffnewsmvp.news.MainActivity
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