package com.meetpeople.domain

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val id: Long,
    val country: String,
    val city: String,
    val coordinates: String
)
