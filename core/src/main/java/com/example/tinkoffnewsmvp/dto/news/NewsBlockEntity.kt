package com.example.tinkoffnewsmvp.dto.news

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsBlock")
data class NewsBlockEntity(
    @PrimaryKey val id: String,
    val name: String,
    val text: String,
    val publicationDate: Long
)