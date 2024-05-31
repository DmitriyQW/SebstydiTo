package com.sebstudi.sebstudy.domain.models.resume.values

data class StudentGroup(val studentGroup: String) {
    init {
        require(studentGroup.length <= 15){"Группа студента не должна превышать 15 символов"}
    }
}