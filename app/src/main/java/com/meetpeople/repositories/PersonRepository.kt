package com.meetpeople.repositories

import com.meetpeople.domain.ResponseBodies
import com.meetpeople.domain.TextResponse
import com.meetpeople.domain.entities.Person
import com.meetpeople.retrofit.RetrofitResponse
import com.meetpeople.retrofit.api.PersonAPI
import com.meetpeople.retrofit.bodies
import com.meetpeople.retrofit.errorResponse
import com.meetpeople.utils.JwtUtils
import javax.inject.Inject

class PersonRepository @Inject constructor(private val personApi: PersonAPI) : Repository<Person> {

    override suspend fun fetchAll(token: String): ResponseBodies<List<Person>> =
        bodies(personApi.fetchAll(JwtUtils.bearer(token)))

    override suspend fun fetchOne(token: String, id: Long): ResponseBodies<Person> =
        bodies(personApi.fetchOne(JwtUtils.bearer(token), id))

    override suspend fun create(token: String, t: Person): ResponseBodies<Person> =
        bodies(personApi.create(JwtUtils.bearer(token), t))

    override suspend fun update(token: String, t: Person): ResponseBodies<Person> =
        bodies(personApi.update(JwtUtils.bearer(token), t))

    override suspend fun delete(token: String, id: Long): ResponseBodies<TextResponse> =
        bodies(personApi.delete(JwtUtils.bearer(token), id))

}