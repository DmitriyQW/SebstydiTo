package com.sebstydi.sebstydi.domain.models.resume.values

data class Direction(val direction: String) {
    init {
        require(direction.length <= 50 && !direction.startsWith(" ")&&!direction.isEmpty()){"Направление не должно превышать 50 символов"}
    }
}