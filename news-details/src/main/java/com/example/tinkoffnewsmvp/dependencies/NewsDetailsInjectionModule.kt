package com.example.tinkoffnewsmvp.dependencies

import com.example.tinkoffnewsmvp.NewsDetailsActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [NewsDetailsComponent::class])
interface NewsDetailsInjectionModule {

    @Binds
    @IntoMap
    @ClassKey(NewsDetailsActivity::class)
    fun bindNewsDetailsActivityFactory(factory: NewsDetailsComponent.Factory): AndroidInjector.Factory<*>

}