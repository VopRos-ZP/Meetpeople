package com.meetpeople.retrofit.api

import com.meetpeople.domain.LoginRequest
import com.meetpeople.domain.entities.Person
import com.meetpeople.domain.TextResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {

    @POST("auth/login")
    suspend fun login(@Body body: LoginRequest): Response<String>

    @POST("auth/registration")
    suspend fun registration(@Body person: Person): TextResponse

    @POST("auth/logout")
    suspend fun logout(@Body person: Person): Response<TextResponse>

}