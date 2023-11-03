package com.meetpeople.views.root

sealed class RootViewIntent {
    data class Launch(val id: Long) : RootViewIntent()
}