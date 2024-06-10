package com.sebstydi.sebstydi.presentation.resume.state

import LastName
import com.sebstydi.sebstydi.domain.models.resume.values.AboutMe
import com.sebstydi.sebstydi.domain.models.resume.values.AboutProjects
import com.sebstydi.sebstydi.domain.models.resume.values.Direction
import com.sebstydi.sebstydi.domain.models.resume.values.Educations
import com.sebstydi.sebstydi.domain.models.resume.values.FirstName
import com.sebstydi.sebstydi.domain.models.resume.values.MidleName
import com.sebstydi.sebstydi.domain.models.resume.values.PhoneNumber
import com.sebstydi.sebstydi.domain.models.resume.values.Portfolio
import com.sebstydi.sebstydi.domain.models.resume.values.Skill
import com.sebstydi.sebstydi.domain.models.resume.values.Skills

sealed interface ResumeEvent {
    object OnAddNewPhotoClick : ResumeEvent
    data class OnFirstNameChanged(val value: FirstName) : ResumeEvent

    data class OnLastNameChanged(val value: LastName) : ResumeEvent

    data class OnMidleNameChanged(val value: MidleName) : ResumeEvent

    data class OnPhoneNumberChanged(val value: PhoneNumber) : ResumeEvent

    data class OnEducationsChanged(val value: Educations) : ResumeEvent

    data class OnAboutMeChanged(val value: AboutMe) : ResumeEvent

    data class OnDirectionsChanged(val value: Direction) : ResumeEvent

    data class OnAboutProjectChanged(val value: AboutProjects): ResumeEvent

    object OnClickAddHardSkills: ResumeEvent

    data class OnSkillsChanged(val value: Skills): ResumeEvent

    object OnClickDismemberSkill: ResumeEvent

    data class OnPortfolioChanged(val value: Portfolio): ResumeEvent

    object OnClickSendResume: ResumeEvent
}