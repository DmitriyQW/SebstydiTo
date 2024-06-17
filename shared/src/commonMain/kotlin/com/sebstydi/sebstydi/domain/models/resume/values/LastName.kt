package com.sebstydi.sebstydi.domain.models.resume.values

data class LastName(val value:String) {
    init {
        validation(value)
    }
}