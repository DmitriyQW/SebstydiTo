package com.sebstudi.sebstudy.domain.models.resume.values

data class AboutProjects(val value: String) {
    init {
        require(value.length <= 400) {
        }
    }
}