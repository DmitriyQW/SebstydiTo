package com.sebstydi.sebstydi.domain.models.resume.values

data class Portfolio(
    val link: String
){
    val urlPattern = "^https?://[a-zA-Z0-9.-]+(?:/[^\\s]*)?\$".toRegex()

    init {
        require(urlPattern.matches(link)) {
            "Ошибка со ссылкой"
        }
    }
}
