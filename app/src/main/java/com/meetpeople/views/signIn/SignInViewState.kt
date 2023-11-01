package com.meetpeople.views.signIn

import com.meetpeople.domain.Person

sealed class SignInViewState {
    data object Loading: SignInViewState()
    data class Success(val person: Person) : SignInViewState()
    data class Error(val message: String) : SignInViewState()
}
