package com.meetpeople.views.main

import com.meetpeople.domain.entities.Person

sealed class MainViewState {
    data object Loading : MainViewState()
    data object Login : MainViewState()
    data class Home(val person: Person) : MainViewState()
    data class Error(val message: String) : MainViewState()
}
