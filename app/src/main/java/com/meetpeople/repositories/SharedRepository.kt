package com.meetpeople.repositories

interface SharedRepository<T> {
    suspend fun put(t: T)
    suspend fun fetch(): T
}