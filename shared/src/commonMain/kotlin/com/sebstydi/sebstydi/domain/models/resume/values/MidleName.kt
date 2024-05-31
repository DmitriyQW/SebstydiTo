package com.sebstudi.sebstudy.domain.models.resume.values

data class MidleName(val value:String) {
    init {
        validation(value)
    }
}