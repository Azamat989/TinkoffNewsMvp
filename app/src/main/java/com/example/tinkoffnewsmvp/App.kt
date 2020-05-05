package com.example.tinkoffnewsmvp

import android.app.Application
import com.example.tinkoffnewsmvp.dependencies.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        buildDependencyGraph()
        Stetho.initializeWithDefaults(this)

    }

    private fun buildDependencyGraph() {
        DaggerAppComponent.builder()
            .setApplicationContext(this)
            .build()
            .also {
                it.inject(this)
            }

    }

    override fun androidInjector(): AndroidInjector<Any> = injector
}