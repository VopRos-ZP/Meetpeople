package com.meetpeople.views.main

import com.meetpeople.datastore.LocalStore
import com.meetpeople.mvi.MviIntentBuilder
import com.meetpeople.mvi.MviModel
import com.meetpeople.repositories.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val localStore: LocalStore,
    private val authRepository: AuthRepository
) : MviModel<MainViewState, MainViewIntent>(
    initState = MainViewState.Loading,
    errorState = { MainViewState.Error(it) }
) {

    override val mviIntentBuilder: MviIntentBuilder<MainViewIntent> = MviIntentBuilder {
        onIntent<MainViewIntent.Launch> { fetchPersons() }
    }

    private suspend fun fetchPersons() {
        localStore.config.collect { (_, _, lr) ->
            if (lr.phone.isNotEmpty() && lr.password.isNotEmpty()) {
                authRepository.login(lr).apply {
                    onError { emitState(MainViewState.Error(it.message)) }
                    onSuccess {
                        emitState(MainViewState.Home(it.result))
                        localStore.saveToken(it.token)
                        localStore.savePhone(lr.phone)
                        localStore.savePassword(lr.password)
                    }
                }
            } else { emitState(MainViewState.Login) }
        }
    }

}