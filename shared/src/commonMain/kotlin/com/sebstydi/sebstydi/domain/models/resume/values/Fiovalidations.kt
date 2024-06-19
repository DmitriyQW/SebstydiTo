package com.sebstydi.sebstydi.domain.models.resume.values

fun validation(valid: String) {
        require(valid.isNotBlank() && valid.length in 1..49) {
                "Имя $valid введено неверно."
        }
        require(valid.matches(Regex("[а-яА-ЯёЁa-zA-Z]+"))) {
                "Имя $valid должно содержать только буквы."
        }
        require(!valid.startsWith("ъ", ignoreCase = true) && !valid.startsWith("ь", ignoreCase = true) && !valid.startsWith(" ")) {
                "Имя $valid введено неверно."
        }
}