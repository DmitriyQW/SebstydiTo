package com.sebstydi.sebstydi.domain.models.resume.values



data class MidleName(val value:String) {
    init {
        validation(value)
    }
}