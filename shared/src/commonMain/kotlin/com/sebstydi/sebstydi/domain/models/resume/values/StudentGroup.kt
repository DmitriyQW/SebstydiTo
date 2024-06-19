package com.sebstydi.sebstydi.domain.models.resume.values

data class StudentGroup(val studentGroup: String) {
    init {
        require(studentGroup.length <= 15 && !studentGroup.startsWith(" ")&& !studentGroup.isEmpty())
        {"Группа студента не должна превышать 15 символов"}
    }
}