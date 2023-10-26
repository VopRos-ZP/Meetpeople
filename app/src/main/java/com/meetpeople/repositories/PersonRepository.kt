package com.meetpeople.repositories

import com.meetpeople.domain.Person
import com.meetpeople.retrofit.API
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject

class PersonRepository @Inject constructor(private val api: API) : Repository<Person> {

    override suspend fun fetchAll(): List<Person> = api.fetchPersons()

    override suspend fun fetchOne(id: Long): Person? = api.fetchPerson(id)

}