package com.meetpeople.retrofit

import com.meetpeople.domain.LoginRequest
import com.meetpeople.domain.Person
import com.meetpeople.domain.Response
import com.meetpeople.domain.TextResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {

    @POST("auth/login")
    suspend fun login(@Body body: LoginRequest): retrofit2.Response<Response<Person>>

    @POST("auth/registration")
    suspend fun registration(@Body person: Person): TextResponse

    @POST("auth/logout")
    suspend fun logout(@Body person: Person): TextResponse

}