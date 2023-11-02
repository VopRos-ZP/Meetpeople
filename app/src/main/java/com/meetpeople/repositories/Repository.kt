package com.meetpeople.repositories

import com.meetpeople.domain.ResponseBodies
import com.meetpeople.domain.TextResponse

interface Repository<T> {
    suspend fun fetchAll(token: String): ResponseBodies<List<T>>
    suspend fun fetchOne(token: String, id: Long): ResponseBodies<T>
    suspend fun create(token: String, t: T): ResponseBodies<T>
    suspend fun update(token: String, t: T): ResponseBodies<T>
    suspend fun delete(token: String, id: Long): ResponseBodies<TextResponse>
}