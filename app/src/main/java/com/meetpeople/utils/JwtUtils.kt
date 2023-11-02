package com.meetpeople.utils

object JwtUtils {

    fun bearer(token: String): String = "Bearer $token"

}