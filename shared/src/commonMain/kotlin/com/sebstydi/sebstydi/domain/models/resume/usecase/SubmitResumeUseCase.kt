package com.sebstydi.sebstydi.domain.models.resume.usecase

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


class SubmitResumeUseCase {

    //Со всем
    fun execute(photo: Photo, lastName:LastName, firstName: FirstName
                , midleName: MidleName, phoneNumber: PhoneNumber, education: Education
                , aboutMe: AboutMe, direction: Directions, aboutProjects: AboutProjects
                , skills: Skills, portfolio: Portfolio
    ){
    }


    //Без о себе
    fun execute(photo: Photo, lastName:LastName, firstName: FirstName
                , midleName: MidleName, phoneNumber: PhoneNumber, education: Education
                , direction: Directions, aboutProjects: AboutProjects
                , skills: Skills, portfolio: Portfolio
    ){
    }

    //Без о проектах
    fun execute(photo: Photo, lastName:LastName, firstName: FirstName
                , midleName: MidleName, phoneNumber: PhoneNumber, education: Education
                , direction: Directions, skills: Skills, portfolio: Portfolio
    ){
    }

    //Без о портфолио
    fun execute(photo: Photo, lastName:LastName, firstName: FirstName
                , midleName: MidleName, phoneNumber: PhoneNumber, education: Education
                , direction: Directions, skills: Skills
    ){
    }
    //Со всем
    fun execute2(photo: Photo, lastName:LastName, firstName: FirstName
                , midleName: MidleName, phoneNumber: PhoneNumber, education: Education
                , aboutMe: AboutMe?, direction: Directions, aboutProjects: AboutProjects?
                , skills: Skills, portfolio: Portfolio?){
    }

}