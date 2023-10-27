package com.meetpeople.retrofit

import com.meetpeople.domain.Person
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    @GET("persons/")
    suspend fun fetchPersons(): List<Person>

    @GET("persons/{id}")
    suspend fun fetchPerson(@Path("id") id: Long): Person?

}