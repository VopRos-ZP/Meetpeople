package com.meetpeople.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.meetpeople.retrofit.API
import com.meetpeople.retrofit.AuthAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.1.103:8088/api/v0/")
        .client(client)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()

    @Provides
    fun provideAPI(retrofit: Retrofit): API = retrofit.create(API::class.java)

    @Provides
    fun provideAuthAPI(retrofit: Retrofit): AuthAPI = retrofit.create(AuthAPI::class.java)

}