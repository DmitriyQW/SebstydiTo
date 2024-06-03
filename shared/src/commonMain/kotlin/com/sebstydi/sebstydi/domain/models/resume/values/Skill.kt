package com.sebstydi.sebstydi.domain.models.resume.values


data class Skill(val value: String){
        val pattern = "[A-Za-zА-Яа-яЁё]{30,}".toRegex()
        init {
            require(pattern.matches(value)){
                "Скилл $value не согласуются с $pattern!"
            }
        }
}
