package com.example.tinkoffnewsmvp.dependencies

import android.content.Context
import com.example.tinkoffnewsmvp.App
import com.example.tinkoffnewsmvp.dependencies.api.ApiModule
import com.example.tinkoffnewsmvp.dependencies.app.AppModule
import com.example.tinkoffnewsmvp.dependencies.database.DatabaseModule
import com.example.tinkoffnewsmvp.dependencies.repository.NewsRepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        DatabaseModule::class,
        NewsRepositoryModule::class,
        InjectionModule::class
    ]
)
interface AppComponent {

    fun inject(app: App)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun setApplicationContext(context: Context): Builder

        fun build(): AppComponent

    }
}