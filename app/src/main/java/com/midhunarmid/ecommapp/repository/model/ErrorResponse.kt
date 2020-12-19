package com.midhunarmid.ecommapp.repository.model

data class ErrorResponse(val error: String?, val errorMessage: String?, val status: Int?) : Throwable() {
    constructor() : this("UNKNOWN", "Unknown Error", 1)
}