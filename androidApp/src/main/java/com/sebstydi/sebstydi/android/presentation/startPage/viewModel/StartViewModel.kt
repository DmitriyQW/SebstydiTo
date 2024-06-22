package com.sebstydi.sebstydi.android.presentation.startPage.viewModel

import com.sebstydi.sebstydi.presentation.startPage.state.StartEffect
import com.sebstydi.sebstydi.presentation.startPage.viewModel.ISplashViewModel
import com.sebstydi.sebstydi.presentation.startPage.state.StatusStartPage
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebstydi.sebstydi.presentation.startPage.state.StartEvent
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

class StartViewModel : ViewModel(), ISplashViewModel {
    private val _state = MutableStateFlow(StatusStartPage())
    override val state: StateFlow<StatusStartPage> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<StartEffect>()
    override val effect: SharedFlow<StartEffect> = _effect

    init {
        viewModelScope.launch {
            delay(2000)
            _effect.emit(StartEffect.NavigateToNextScreen)
        }
    }

    override fun onEvent(event: StartEvent) {
        when (event) {
            StartEvent.OnTimeout -> {
                viewModelScope.launch {
                    _effect.emit(StartEffect.NavigateToNextScreen)
                }
            }
        }
    }
}
