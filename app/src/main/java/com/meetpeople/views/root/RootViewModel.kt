package com.meetpeople.views.root

import com.meetpeople.datastore.LocalStore
import com.meetpeople.mvi.MviIntentBuilder
import com.meetpeople.mvi.MviModel
import com.meetpeople.repositories.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RootViewModel @Inject constructor(
    private val localStore: LocalStore,
    private val personRepository: PersonRepository
) : MviModel<RootViewState, RootViewIntent>(
    initState = RootViewState.Loading,
    errorState = { RootViewState.Error(it) }
) {

    override val mviIntentBuilder = MviIntentBuilder<RootViewIntent> {
        onIntent<RootViewIntent.Launch> { fetchPerson(it.id) }
    }

    private suspend fun fetchPerson(id: Long) {
        localStore.token.collect { token ->
            if (token == null) return@collect
            personRepository.fetchOne(token, id).apply {
                onError { emitState(RootViewState.Error(it.message)) }
                onSuccess { emitState(RootViewState.Success(it.result)) }
            }
        }
    }

}