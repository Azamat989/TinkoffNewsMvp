package com.example.tinkoffnewsmvp.services

import com.example.tinkoffnewsmvp.dto.news.NewsResponse
import retrofit2.http.GET

interface NewsApi {

    @GET("news")
    suspend fun getNews(): NewsResponse

}