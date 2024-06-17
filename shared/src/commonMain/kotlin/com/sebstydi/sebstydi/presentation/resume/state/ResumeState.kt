package com.sebstydi.sebstydi.presentation.resume.state

import com.sebstydi.sebstydi.domain.models.resume.values.*

data class ResumeState(
    val firstNameError: FirstName? = null,
    val lastNameError: LastName? = null,
    val midleNameError: MidleName? = null,
    val phoneNumberError: PhoneNumber? = null,
    val educationError: Educations? = null,
    val direction: Direction? = null,
    val isAddSkill: Boolean = false,
    val isDeleteSkill: Boolean = false,
    val isResumeSend: Boolean = false,
    val aboutMe: AboutMe? = null,
    val aboutProjects: AboutProjects? = null,
    val skills: Skills? = null,
    val portfolio: Portfolio? = null
)

