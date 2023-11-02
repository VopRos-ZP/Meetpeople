package com.meetpeople.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class MviModel<S, I>(
    initState: S,
    private val errorState: (String) -> S
) : ViewModel() {

    private val _viewState = MutableStateFlow(initState)
    val viewState = _viewState.asStateFlow()

    private val mviIntentImpl = MviIntentImpl<I>()

    abstract val mviIntentBuilder: MviIntentBuilder<I>

    private val errorHandler = CoroutineExceptionHandler { _, err ->
        viewModelScope.launch { emitState(errorState(err.localizedMessage ?: "")) }
    }

    private fun coroutine(content: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch(context = errorHandler, block = content)
    }

    fun intent(intent: I) {
        coroutine { mviIntentImpl.execIntent(this, mviIntentBuilder.intents, intent) }
    }

    protected suspend fun emitState(state: S) {
        _viewState.emit(state)
    }

}