package com.sebstydi.sebstydi.domain.models.resume.values


fun validation(valid:String){

        require(!valid.matches(Regex("[0-9]")) &&
                !valid.matches(Regex("[a-zA-Z]")) &&
                !valid.startsWith("ъ") && !valid.startsWith("ь")&&
                !valid.startsWith(" ") && valid.length > 0 && valid.length < 50) {
                "Имя  $valid введено неверно."}

}