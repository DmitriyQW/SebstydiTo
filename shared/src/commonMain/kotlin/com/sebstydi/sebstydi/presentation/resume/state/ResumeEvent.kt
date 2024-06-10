package com.sebstydi.sebstydi.presentation.resume.state

import LastName
import com.sebstydi.sebstydi.domain.models.resume.values.AboutMe
import com.sebstydi.sebstydi.domain.models.resume.values.Direction
import com.sebstydi.sebstydi.domain.models.resume.values.Educations
import com.sebstydi.sebstydi.domain.models.resume.values.FirstName
import com.sebstydi.sebstydi.domain.models.resume.values.MidleName
import com.sebstydi.sebstydi.domain.models.resume.values.PhoneNumber

sealed interface ResumeEvent {
    object OnAddNewPhotoClick : ResumeEvent
    data class OnFirstNameChanged(val value: FirstName) : ResumeEvent
    data class OnLastNameChanged(val value: LastName) : ResumeEvent
    data class OnMidleNameChanged(val value: MidleName) : ResumeEvent

    data class OnPhoneNumberChanged(val value: PhoneNumber) : ResumeEvent

    data class OnEducationsChanged(val value: Educations) : ResumeEvent

    data class OnAboutMeChanged(val value: AboutMe) : ResumeEvent

    data class OnDirectionsChanged(val value: Direction) : ResumeEvent
}