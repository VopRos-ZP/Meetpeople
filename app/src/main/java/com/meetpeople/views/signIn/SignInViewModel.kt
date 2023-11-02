package com.meetpeople.views.signIn

import android.util.Log
import com.meetpeople.domain.LoginRequest
import com.meetpeople.domain.entities.Person
import com.meetpeople.domain.Response
import com.meetpeople.domain.TextResponse
import com.meetpeople.repositories.AuthRepository
import com.meetpeople.mvi.MviIntentBuilder
import com.meetpeople.mvi.MviModel
import com.meetpeople.repositories.TokenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.serialization.json.Json
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val tokenRepository: TokenRepository
) : MviModel<SignInViewState, SignInViewIntent>(
    initState = SignInViewState.Loading,
    errorState = { SignInViewState.Error(it) }
) {

    override val mviIntentBuilder = MviIntentBuilder<SignInViewIntent> {
        onIntent<SignInViewIntent.Launch> { emitState(SignInViewState.Loading) }
        onIntent<SignInViewIntent.SignIn> { signIn(it.phone, it.password) }
    }

    private suspend fun signIn(phone: String, password: String) {
        val response = authRepository.login(LoginRequest(phone, password))
        when {
            response.body() != null -> {
                val res: Response<Person> = Json.decodeFromString(response.body()!!)
                Log.d(SignInViewModel::class.java.simpleName, "${res.result}")
                emitState(SignInViewState.Success(res.result))
                // save token to store
                tokenRepository.put(res.token)
            }
            response.errorBody() != null -> {
                val errResponse: TextResponse = Json.decodeFromString(response.errorBody()!!.string())
                Log.d(SignInViewModel::class.java.simpleName, errResponse.message)
                emitState(SignInViewState.Error(errResponse.message))
            }
        }
    }

}