package com.meetpeople.views.main

sealed class MainViewIntent {
    data object Launch : MainViewIntent()
}
