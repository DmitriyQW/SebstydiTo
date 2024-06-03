package com.sebstydi.sebstydi.domain.models.resume

import LastName
import com.sebstydi.sebstydi.domain.models.resume.values.AboutMe
import com.sebstydi.sebstydi.domain.models.resume.values.AboutProjects
import com.sebstydi.sebstydi.domain.models.resume.values.Directions
import com.sebstydi.sebstydi.domain.models.resume.values.Education
import com.sebstydi.sebstydi.domain.models.resume.values.FirstName
import com.sebstydi.sebstydi.domain.models.resume.values.MidleName
import com.sebstydi.sebstydi.domain.models.resume.values.PhoneNumber
import com.sebstydi.sebstydi.domain.models.resume.values.Photo
import com.sebstydi.sebstydi.domain.models.resume.values.Portfolio
import com.sebstydi.sebstydi.domain.models.resume.values.Skills

class Resume {
    lateinit var photo:Photo
    lateinit var lastName:LastName
    lateinit var firstName:FirstName
    lateinit var midleName:MidleName
    lateinit var phoneNumber:PhoneNumber
    lateinit var education:Education
    lateinit var aboutMe:AboutMe
    lateinit var direction:Directions
    lateinit var aboutProjects:AboutProjects
    lateinit var skills:Skills
    lateinit var portfolio:Portfolio

    constructor(
        photo: Photo,
        lastName: LastName,
        firstName: FirstName,
        midleName: MidleName,
        phoneNumber: PhoneNumber,
        education: Education,
        aboutMe: AboutMe,
        direction: Directions,
        aboutProjects: AboutProjects,
        skills: Skills,
        portfolio: Portfolio
    ) {
        this.photo = photo
        this.lastName = lastName
        this.firstName = firstName
        this.midleName = midleName
        this.phoneNumber = phoneNumber
        this.education = education
        this.aboutMe = aboutMe
        this.direction = direction
        this.aboutProjects = aboutProjects
        this.skills = skills
        this.portfolio = portfolio
    }
}

