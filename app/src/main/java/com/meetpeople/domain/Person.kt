package com.meetpeople.domain

data class Person(
    val id: String,
    val phone: String,
    val firstname: String,
    val lastname: String,
    val age: Int,
    val location: String,
    val images: List<String>,
    val vkId: String
)
