package com.sebstydi.sebstydi.domain.usecase

import org.koin.dsl.module


class ResumeUseCaseConfiguration {

    fun sendResumeUseCase() = SendResumeUseCase()


    val ResumeModule = module {
        single { sendResumeUseCase() }
    }


}

