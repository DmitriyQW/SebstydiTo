package com.sebstydi.sebstydi.presentation.resume.state

import LastName
import com.sebstydi.sebstydi.domain.models.resume.values.FirstName
import com.sebstydi.sebstydi.domain.models.resume.values.MidleName

sealed interface ResumeEvent {
    object OnAddNewPhotoClick : ResumeEvent
    data class OnFirstNameChanged(val value: FirstName) : ResumeEvent
    data class OnLastNameChanged(val value: LastName) : ResumeEvent
    data class OnMidleNameChanged(val value: MidleName) : ResumeEvent
}