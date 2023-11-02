package com.meetpeople.mvi

import kotlinx.coroutines.CoroutineScope

class MviIntentImpl<I> {

    suspend fun execIntent(
        scope: CoroutineScope,
        intents: List<suspend CoroutineScope.(I) -> Boolean>,
        intent: I
    ) {
        for (handler in intents) {
            if (handler(scope, intent)) break
        }
    }

}