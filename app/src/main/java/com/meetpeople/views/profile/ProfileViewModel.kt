package com.meetpeople.views.profile

import com.meetpeople.datastore.LocalStore
import com.meetpeople.mvi.MviIntentBuilder
import com.meetpeople.mvi.MviModel
import com.meetpeople.repositories.PersonRepository
import com.meetpeople.utils.JwtUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val localStore: LocalStore,
    private val personRepository: PersonRepository
) : MviModel<ProfileViewState, ProfileViewIntent>(
    initState = ProfileViewState.Loading,
    errorState = { ProfileViewState.Error(it) }
) {

    override val mviIntentBuilder = MviIntentBuilder<ProfileViewIntent> {
        onIntent<ProfileViewIntent.Launch> { fetchPerson(it.id) }
    }

    private suspend fun fetchPerson(id: Long) {
        localStore.token.collect { token ->
            if (token == null) return@collect
            personRepository.fetchOne(JwtUtils.bearer(token), id).apply {
                onError { emitState(ProfileViewState.Error(it.message)) }
                onSuccess { emitState(ProfileViewState.Success(it.result)) }
            }
        }
    }

}