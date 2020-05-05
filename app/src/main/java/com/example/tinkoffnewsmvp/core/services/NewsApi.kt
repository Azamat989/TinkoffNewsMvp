package com.example.tinkoffnewsmvp.core.services

import com.example.tinkoffnewsmvp.core.dto.news.NewsResponse
import retrofit2.http.GET

interface NewsApi {

    @GET("news")
    suspend fun getNews(): NewsResponse

}