package com.sebstudi.sebstudy.domain.models.resume.values

data class AboutMe(val value: String) {
    init {
        require(value.length <= 350) {

        }
    }
}
