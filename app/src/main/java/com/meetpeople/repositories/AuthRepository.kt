package com.meetpeople.repositories

import com.meetpeople.domain.LoginRequest
import com.meetpeople.domain.ResponseBodies
import com.meetpeople.domain.entities.Person
import com.meetpeople.retrofit.api.AuthAPI
import com.meetpeople.retrofit.bodies
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authAPI: AuthAPI) {

    suspend fun login(body: LoginRequest): ResponseBodies<Person> = bodies(authAPI.login(body))
    suspend fun registration(person: Person) = authAPI.registration(person)
    suspend fun logout(token: String, id: Long) = authAPI.logout(token, id)
}