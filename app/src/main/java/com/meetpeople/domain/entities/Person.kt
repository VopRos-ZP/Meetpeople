package com.meetpeople.domain.entities

import com.meetpeople.domain.entities.Location
import com.meetpeople.domain.entities.Session
import kotlinx.serialization.Serializable

@Serializable
data class Person(
    val id: Long,
    val firstname: String,
    val lastname: String,
    val password: String,
    val phone: String,
    val gender: String,
    val birthday: Long,
    val location: Location,
    val maritalStatus: String,
    val status: String,
    val about: String,
    val premium: Boolean,
    val vkId: String?,
    val onlineStatus: String,
    val sessions: Set<Session>
)
