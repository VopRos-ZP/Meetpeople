package com.meetpeople.retrofit.api

import com.meetpeople.domain.LoginRequest
import com.meetpeople.domain.entities.Person
import com.meetpeople.domain.TextResponse
import com.meetpeople.retrofit.RetrofitResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthAPI {

    @POST("auth/login")
    suspend fun login(@Body body: LoginRequest): RetrofitResponse<Person>

    @POST("auth/registration")
    suspend fun registration(@Body person: Person): TextResponse

    @POST("auth/logout/{id}")
    suspend fun logout(@Header("Authorization") token: String, @Path("id") id: Long): TextResponse

}