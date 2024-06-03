package com.sebstydi.sebstydi.state

enum class StatusResponse(error:Throwable? = null) {
    OK,
    Error
}