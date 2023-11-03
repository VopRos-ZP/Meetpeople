package com.meetpeople.views.splash

sealed class SplashViewIntent {
    data object Launch : SplashViewIntent()
}
