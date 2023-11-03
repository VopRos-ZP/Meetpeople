package com.meetpeople.views.profile

sealed class ProfileViewIntent {
    data object Launch : ProfileViewIntent()
}