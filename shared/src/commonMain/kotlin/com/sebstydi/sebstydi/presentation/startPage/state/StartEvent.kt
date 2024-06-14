package com.sebstydi.sebstydi.presentation.startPage.state

sealed class StartEvent {
    object OnTimeout : StartEvent()
}