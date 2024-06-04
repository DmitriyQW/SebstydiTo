package com.sebstydi.sebstydi.domain.models.resume.values

data class Photo(val url_photo: String) {
    val imageUrlPattern = "^https?:\\S+.(?:jpe?g|png)\$".toRegex(RegexOption.IGNORE_CASE)
    init {
        require(imageUrlPattern.matches(url_photo) && !url_photo.startsWith(" ")&&!url_photo.isEmpty()){
            "Скилл $url_photo не согласуются с $imageUrlPattern!"
        }
    }

}