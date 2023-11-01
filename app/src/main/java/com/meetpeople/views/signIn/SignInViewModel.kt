package com.meetpeople.views.signIn

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meetpeople.domain.LoginRequest
import com.meetpeople.domain.Person
import com.meetpeople.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import retrofit2.awaitResponse
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow<SignInViewState>(SignInViewState.Loading)
    val viewState = _viewState.asStateFlow()

    fun intent(intent: SignInViewIntent) {
        when (intent) {
            is SignInViewIntent.Launch -> loading()
            is SignInViewIntent.SignIn -> signIn(intent.phone, intent.password)
        }
    }

    private fun loading() {
        viewModelScope.launch { _viewState.emit(SignInViewState.Loading) }
    }

    private fun signIn(phone: String, password: String) {
        val handler = CoroutineExceptionHandler { _, throwable ->
            viewModelScope.launch {
                Log.d("SignInViewModel", "ERROR ${throwable.message}")
                _viewState.emit(SignInViewState.Error(throwable.message ?: ""))
            }
        }
        viewModelScope.launch(handler) {
            val call = authRepository.login(LoginRequest(phone, password))
            val response = call.errorBody()

            Log.d("SignInViewModel", "$response")
            //viewModelScope.launch { _viewState.emit(SignInViewState.Success(response.result)) }
            // save token to store
        }
    }

}