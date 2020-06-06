package com.example.tinkoffnewsmvp.dependencies.api

import com.example.tinkoffnewsmvp.services.NewsApi
import com.example.tinkoffnewsmvp.services.NewsContentApi
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val BASE_URL = "https://api.tinkoff.ru/v1/"

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideNewsApi(
        okHttBuilder: OkHttpClient,
        converter: Gson
    ): NewsApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttBuilder)
            .addConverterFactory(GsonConverterFactory.create(converter))
            .build()
            .create(NewsApi::class.java)

    @Provides
    @Singleton
    fun provideNewsContentApi(
        okHttBuilder: OkHttpClient,
        converter: Gson
    ): NewsContentApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttBuilder)
            .addConverterFactory(GsonConverterFactory.create(converter))
            .build()
            .create(NewsContentApi::class.java)

    @Provides
    fun provideDefaultOkHttpBuilder(): OkHttpClient =
        OkHttpClient.Builder().apply {
            readTimeout(30L, TimeUnit.SECONDS)
            connectTimeout(30L, TimeUnit.SECONDS)
            addNetworkInterceptor(StethoInterceptor())
        }
            .build()

    @Provides
    @Singleton
    fun provideConverter(): Gson = Gson()

}