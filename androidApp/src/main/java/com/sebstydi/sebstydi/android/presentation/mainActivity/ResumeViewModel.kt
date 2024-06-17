package com.sebstydi.sebstydi.android.presentation.mainActivity

import androidx.lifecycle.ViewModel
import com.sebstydi.sebstydi.domain.models.resume.values.*
import com.sebstydi.sebstydi.presentation.resume.state.ResumeEvent
import com.sebstydi.sebstydi.presentation.resume.state.ResumeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ResumeViewModel : ViewModel() {
    private val _state = MutableStateFlow(ResumeState())
    val state: StateFlow<ResumeState> = _state

    fun onEvent(event: ResumeEvent) {
        when (event) {
            is ResumeEvent.OnFirstNameChanged -> {
                _state.value = _state.value.copy(firstNameError = event.value)
            }
            is ResumeEvent.OnLastNameChanged -> {
                _state.value = _state.value.copy(lastNameError = event.value)
            }
            is ResumeEvent.OnMidleNameChanged -> {
                _state.value = _state.value.copy(midleNameError = event.value)
            }
            is ResumeEvent.OnPhoneNumberChanged -> {
                _state.value = _state.value.copy(phoneNumberError = event.value)
            }
            is ResumeEvent.OnEducationsChanged -> {
                _state.value = _state.value.copy(educationError = event.value)
            }
            is ResumeEvent.OnAboutMeChanged -> {
                _state.value = _state.value.copy(aboutMe = event.value)
            }
            is ResumeEvent.OnDirectionsChanged -> {
                _state.value = _state.value.copy(direction = event.value)
            }
            is ResumeEvent.OnAboutProjectChanged -> {
                _state.value = _state.value.copy(aboutProjects = event.value)
            }
            is ResumeEvent.OnClickAddHardSkills -> {
                _state.value = _state.value.copy(isAddSkill = true)
            }
            is ResumeEvent.OnSkillsChanged -> {
                _state.value = _state.value.copy(skills = event.value)
            }
            is ResumeEvent.OnClickDismemberSkill -> {
                _state.value = _state.value.copy(isDeleteSkill = true)
            }
            is ResumeEvent.OnPortfolioChanged -> {
                _state.value = _state.value.copy(portfolio = event.value)
            }
            is ResumeEvent.OnClickSendResume -> {
                _state.value = _state.value.copy(isResumeSend = true)
            }
            ResumeEvent.OnAddNewPhotoClick -> {
                // handle adding new photo
            }
        }
    }
}

