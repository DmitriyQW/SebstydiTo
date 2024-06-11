package com.sebstydi.sebstydi.presentation.resume.state

import LastName
import com.sebstydi.sebstydi.domain.models.resume.values.Direction
import com.sebstydi.sebstydi.domain.models.resume.values.Education
import com.sebstydi.sebstydi.domain.models.resume.values.FirstName
import com.sebstydi.sebstydi.domain.models.resume.values.MidleName
import com.sebstydi.sebstydi.domain.models.resume.values.PhoneNumber
import com.sebstydi.sebstydi.domain.models.resume.values.Skill

data class ResumeState(
    val firstNameError: FirstName? = null,
    val lastNameError: LastName? = null,
    val midleNameError: MidleName? = null,
    val phoneNumberError: PhoneNumber? = null,
    val educationError: Education? = null,
    val direction: Direction? = null,
    val isAddSkill : Boolean = false,
    val isDeleteSkill : Boolean = false,
    val isResumeSend : Boolean = false
)
