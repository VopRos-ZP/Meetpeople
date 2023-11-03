package com.meetpeople.views.root

import com.meetpeople.domain.entities.Person

sealed class RootViewState {
    data object Loading : RootViewState()
    data class Success(val person: Person) : RootViewState()
    data class Error(val message: String) : RootViewState()
}