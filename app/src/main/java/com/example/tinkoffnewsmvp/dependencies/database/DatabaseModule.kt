package com.example.tinkoffnewsmvp.dependencies.database

import android.content.Context
import androidx.room.Room
import com.example.tinkoffnewsmvp.AppDatabase
import com.example.tinkoffnewsmvp.core.repository.news.NewsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AppDatabase =
        Room
            .databaseBuilder(context.applicationContext, AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideNewsDao(database: AppDatabase): NewsDao =
        database.newsDao()

}