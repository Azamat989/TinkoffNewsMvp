package com.example.tinkoffnewsmvp.services

import com.example.tinkoffnewsmvp.dto.newscontent.NewsContentResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsContentApi {

    @GET("news_content")
    suspend fun getNewsContent(
        @Query("id") id: String
    ): Response<NewsContentResponse>

}