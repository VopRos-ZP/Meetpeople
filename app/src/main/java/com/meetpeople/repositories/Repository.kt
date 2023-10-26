package com.meetpeople.repositories

import kotlinx.coroutines.flow.Flow

interface Repository<T> {
    suspend fun fetchAll(): List<T>
    suspend fun fetchOne(id: Long): T?
}