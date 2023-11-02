package com.meetpeople.views.signIn

import com.meetpeople.datastore.LocalStore
import com.meetpeople.domain.LoginRequest
import com.meetpeople.mvi.MviIntentBuilder
import com.meetpeople.mvi.MviModel
import com.meetpeople.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val localStore: LocalStore,
    private val authRepository: AuthRepository,
) : MviModel<SignInViewState, SignInViewIntent>(
    initState = SignInViewState.Loading,
    errorState = { SignInViewState.Error(it) }
) {

    override val mviIntentBuilder = MviIntentBuilder<SignInViewIntent> {
        onIntent<SignInViewIntent.Launch> { emitState(SignInViewState.Loading) }
        onIntent<SignInViewIntent.SignIn> { signIn(it.phone, it.password) }
    }

    private suspend fun signIn(phone: String, password: String) {
        authRepository.login(LoginRequest(phone, password)).apply {
            onSuccess {
                emitState(SignInViewState.Success(it.result))
                localStore.saveToken(it.token)
            }
            onError {
                emitState(SignInViewState.Error(it.message))
            }
        }
    }

}