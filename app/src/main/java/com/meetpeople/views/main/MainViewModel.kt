package com.meetpeople.views.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meetpeople.domain.Person
import com.meetpeople.repositories.PersonRepository
import com.meetpeople.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val personRepository: PersonRepository
) : ViewModel() {

    private val _persons = MutableStateFlow<List<Person>?>(null)
    val persons = _persons.asStateFlow()

    fun fetchPersons() {
        viewModelScope.launch {
            _persons.emit(personRepository.fetchAll())
        }
    }

}