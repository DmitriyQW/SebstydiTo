package com.sebstudi.sebstudy.domain.models.resume.values

data class PhoneNumber(val value: String) {
    init {
        require(!value.matches(Regex("[0-9]")))
            value.matches(Regex("\\d{11}"))
                "Номер телефона должен содержать 11 цифр"
    }
}