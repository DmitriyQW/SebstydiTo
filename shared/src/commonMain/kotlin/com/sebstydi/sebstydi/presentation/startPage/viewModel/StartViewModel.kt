package com.sebstydi.sebstydi.presentation.startPage.viewModel

import com.sebstydi.sebstydi.presentation.startPage.state.StartEffect
import com.sebstydi.sebstydi.presentation.startPage.state.StartEvent
import com.sebstydi.sebstydi.presentation.ui.startPage.state.StatusStartPage
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface ISplashViewModel {
    val state: StateFlow<StatusStartPage>
    val effect: SharedFlow<StartEffect>
    fun onEvent(event: StartEvent)
}
