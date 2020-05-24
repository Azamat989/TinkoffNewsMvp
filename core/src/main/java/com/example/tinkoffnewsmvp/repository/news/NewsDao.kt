package com.example.tinkoffnewsmvp.repository.news

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tinkoffnewsmvp.dto.news.NewsBlockEntity

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<NewsBlockEntity>)

    @Query("SELECT * FROM newsBlock LIMIT :loadSize OFFSET :startPosition")
    fun select(startPosition: Int, loadSize: Int): List<NewsBlockEntity>

    @Query("DELETE FROM newsBlock")
    suspend fun deleteAll()

    @Query("SELECT count(*) FROM newsBlock")
    suspend fun countNews(): Int

}