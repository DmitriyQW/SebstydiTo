package com.sebstydi.sebstydi.domain.usecase


import com.sebstydi.sebstydi.domain.models.resume.Resume
import com.sebstydi.sebstydi.state.StatusResponse


class SubmitResumeUseCase {


    fun execute(resume: Resume): StatusResponse {
        if (resume.aboutMe.toString().isEmpty()
            || resume.aboutProjects.toString().isEmpty()
            ||resume.portfolio.toString().isEmpty()){
            return StatusResponse.Error
        }else{
            return StatusResponse.OK
        }
    }
}