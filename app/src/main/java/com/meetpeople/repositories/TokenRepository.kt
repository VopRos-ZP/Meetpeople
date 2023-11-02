package com.meetpeople.repositories

import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class TokenRepository @Inject constructor() : SharedRepository<String> {

    private val tokens = MutableStateFlow("")

    override suspend fun put(t: String) {
        tokens.emit(t)
    }

    override suspend fun fetch(): String {
        return tokens.value
    }
}