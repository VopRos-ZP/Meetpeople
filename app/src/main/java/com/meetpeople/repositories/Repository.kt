package com.meetpeople.repositories

interface Repository<T> {
    suspend fun fetchAll(): List<T>
    suspend fun fetchOne(id: Long): T?
}