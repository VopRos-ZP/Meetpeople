package com.meetpeople.views.splash

import com.meetpeople.datastore.LocalStore
import com.meetpeople.mvi.MviIntentBuilder
import com.meetpeople.mvi.MviModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val localStore: LocalStore
) : MviModel<SplashViewState, SplashViewIntent>(
    initState = SplashViewState.Loading,
    errorState = { SplashViewState.Error(it) }
) {

    override val mviIntentBuilder = MviIntentBuilder<SplashViewIntent> {
        onIntent<SplashViewIntent.Launch> { fetchConfig() }
    }

    private suspend fun fetchConfig() {
        localStore.phone.collect { phone ->
            emitState(SplashViewState.Success(phone != null))
        }
    }

}