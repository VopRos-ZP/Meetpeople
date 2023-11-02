package com.meetpeople.views.main

import android.util.Log
import com.meetpeople.datastore.LocalStore
import com.meetpeople.mvi.MviIntentBuilder
import com.meetpeople.mvi.MviModel
import com.meetpeople.repositories.PersonRepository
import com.meetpeople.utils.JwtUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val localStore: LocalStore,
    private val personRepository: PersonRepository
) : MviModel<MainViewState, MainViewIntent>(
    initState = MainViewState.Loading,
    errorState = { MainViewState.Error(it) }
) {

    override val mviIntentBuilder: MviIntentBuilder<MainViewIntent> = MviIntentBuilder {
        onIntent<MainViewIntent.Launch> { fetchPersons() }
    }

    private suspend fun fetchPersons() {
        localStore.token.collect { token ->
            if (token == null) return@collect
            personRepository.fetchAll(JwtUtils.bearer(token)).apply {
                onSuccess { emitState(MainViewState.Success(it.result)) }
                onError { emitState(MainViewState.Error(it.message)) }
            }
        }
    }

}