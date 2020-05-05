package com.example.tinkoffnewsmvp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tinkoffnewsmvp.core.repository.news.NewsDao
import com.example.tinkoffnewsmvp.core.dto.news.NewsBlockEntity


@Database(entities = [NewsBlockEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun newsDao(): NewsDao

    companion object {
        const val DATABASE_NAME = "app_db"
    }

}