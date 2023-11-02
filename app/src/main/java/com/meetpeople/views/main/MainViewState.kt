package com.meetpeople.views.main

import com.meetpeople.domain.entities.Person

sealed class MainViewState {
    data object Loading : MainViewState()
    data class Success(val persons: List<Person>) : MainViewState()
    data class Error(val message: String) : MainViewState()
}
