package com.meetpeople.views.profile

sealed class ProfileViewIntent {
    data class Launch(val id: Long) : ProfileViewIntent()
}