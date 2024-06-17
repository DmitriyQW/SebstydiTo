package com.sebstydi.sebstydi.domain.models.resume.values

data class FirstName(val value:String) {
 init {
    validation(value)
 }
}




