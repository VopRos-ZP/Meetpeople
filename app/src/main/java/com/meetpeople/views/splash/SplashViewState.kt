package com.meetpeople.views.splash

sealed class SplashViewState {
    data object Loading : SplashViewState()
    data class Success(val isSign: Boolean) : SplashViewState()
    data class Error(val message: String) : SplashViewState()
}