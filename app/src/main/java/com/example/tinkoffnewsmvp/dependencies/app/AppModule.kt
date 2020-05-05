package com.example.tinkoffnewsmvp.dependencies.app

import com.example.tinkoffnewsmvp.IntentFactoryImpl
import com.example.tinkoffnewsmvp.core_ui.factory.IntentFactory
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule

@Module(
    includes = [AndroidSupportInjectionModule::class]
)
interface AppModule {

    @Binds
    fun bindIntentFactory(impl: IntentFactoryImpl): IntentFactory

}