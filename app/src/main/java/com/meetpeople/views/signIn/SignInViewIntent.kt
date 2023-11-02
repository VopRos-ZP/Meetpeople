package com.meetpeople.views.signIn

sealed class SignInViewIntent {
    data object Launch : SignInViewIntent()
    data class SignIn(val phone: String, val password: String) : SignInViewIntent()
}
