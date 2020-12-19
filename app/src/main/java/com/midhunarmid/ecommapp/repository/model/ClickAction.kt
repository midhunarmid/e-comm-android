package com.midhunarmid.ecommapp.repository.model


import com.squareup.moshi.Json
data class ClickAction(
    @Json(name = "open")
    val `open`: String? = null,
    @Json(name = "params")
    val params: String? = null,
    @Json(name = "target")
    val target: String? = null
)