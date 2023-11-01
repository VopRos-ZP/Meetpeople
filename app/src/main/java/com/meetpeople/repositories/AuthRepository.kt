package com.meetpeople.repositories

import com.meetpeople.domain.LoginRequest
import com.meetpeople.domain.Person
import com.meetpeople.retrofit.AuthAPI
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authAPI: AuthAPI) {

    suspend fun login(body: LoginRequest) = authAPI.login(body)
    suspend fun registration(person: Person) = authAPI.registration(person)
    suspend fun logout(person: Person) = authAPI.logout(person)
}