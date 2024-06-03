package com.sebstydi.sebstydi.domain.models.resume.values

data class Portfolio(
    val link: String
){
    val urlPattern = "^https?://[a-zA-Z0-9.-]+(?:/[^\\s]*)?\$".toRegex()

    init {
        require(urlPattern.matches(link) && !link.startsWith(" ") && link.length > 0) {
            "Ошибка со ссылкой"
        }
    }
}
