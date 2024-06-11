package com.sebstydi.sebstydi.presentation.resume.state

import LastName
import com.sebstydi.sebstydi.domain.models.resume.values.FirstName
import com.sebstydi.sebstydi.domain.models.resume.values.MidleName
import com.sebstydi.sebstydi.domain.models.resume.values.PhoneNumber

data class ResumeState(
    val firstNameError: FirstName? = null,
    val lastNameError: LastName? = null,
    val midleNameError: MidleName? = null,
    val phoneNumberError: PhoneNumber? = null,
    val isResumSend : Boolean = false
)
