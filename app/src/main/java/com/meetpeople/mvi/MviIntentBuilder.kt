package com.meetpeople.mvi

import kotlinx.coroutines.CoroutineScope

class MviIntentBuilder<I> internal constructor() {

    val intents = ArrayList<suspend CoroutineScope.(I) -> Boolean>()

    inline fun <reified I> onIntent(noinline handler: suspend CoroutineScope.(intent: I) -> Unit) {
        intents += {
            if (it is I) {
                handler(this, it)
                true
            } else {
                false
            }
        }
    }

}

fun <I> MviIntentBuilder(
    content: MviIntentBuilder<I>.() -> Unit
): MviIntentBuilder<I> = MviIntentBuilder<I>().apply(content)