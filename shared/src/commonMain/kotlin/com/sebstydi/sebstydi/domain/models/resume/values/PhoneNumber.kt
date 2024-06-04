package com.sebstydi.sebstydi.domain.models.resume.values

data class PhoneNumber(val value: String) {
    init {
        require(!value.matches(Regex("[0-9]")) && !value.startsWith(" ")&&!value.isEmpty())
            value.matches(Regex("\\d{11}"))
                "Номер телефона должен содержать 11 цифр"
    }
}