package com.meetpeople.views.main

import com.meetpeople.mvi.MviIntentBuilder
import com.meetpeople.mvi.MviModel
import com.meetpeople.repositories.PersonRepository
import com.meetpeople.repositories.TokenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val personRepository: PersonRepository,
    private val tokenRepository: TokenRepository
) : MviModel<MainViewState, MainViewIntent>(
    initState = MainViewState.Loading,
    errorState = { MainViewState.Error(it) }
) {

    override val mviIntentBuilder: MviIntentBuilder<MainViewIntent> = MviIntentBuilder {
        onIntent<MainViewIntent.Launch> { fetchPersons() }
    }

    private suspend fun fetchPersons() {
        val token = tokenRepository.fetch()
        val response = personRepository.fetchAll(token)
        response.onSuccess { emitState(MainViewState.Success(it.result)) }
        response.onError { emitState(MainViewState.Error(it.message)) }
    }

}