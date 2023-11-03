package com.meetpeople.domain.entities

import kotlinx.serialization.Serializable

@Serializable
data class Location(
    val id: Long,
    val country: String,
    val city: String,
    val coordinates: String
) : java.io.Serializable
