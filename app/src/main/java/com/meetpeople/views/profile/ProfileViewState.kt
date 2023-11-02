package com.meetpeople.views.profile

import com.meetpeople.domain.entities.Person

sealed class ProfileViewState {
    data object Loading : ProfileViewState()
    data class Success(val person: Person) : ProfileViewState()
    data class Error(val message: String) : ProfileViewState()
}