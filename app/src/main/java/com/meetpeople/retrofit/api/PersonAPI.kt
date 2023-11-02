package com.meetpeople.retrofit.api

import com.meetpeople.domain.TextResponse
import com.meetpeople.domain.entities.Person
import com.meetpeople.retrofit.RetrofitResponse
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PersonAPI {

    @GET("persons/")
    suspend fun fetchAll(@Header("Authorization") token: String): RetrofitResponse<List<Person>>

    @GET("persons/{id}")
     suspend fun fetchOne(
        @Header("Authorization") token: String,
        @Path("id") id: Long
    ): RetrofitResponse<Person>

    @POST("persons/")
     suspend fun create(
        @Header("Authorization") token: String,
        @Body t: Person
    ): RetrofitResponse<Person>

    @PUT("persons/{id}")
     suspend fun update(
        @Header("Authorization") token: String,
        @Path("id") id: Long,
        @Body t: Person
    ): RetrofitResponse<Person>

    @DELETE("persons/{id}")
     suspend fun delete(
        @Header("Authorization") token: String,
        @Path("id") id: Long
    ): RetrofitResponse<TextResponse>

}