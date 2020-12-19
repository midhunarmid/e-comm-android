package com.midhunarmid.ecommapp.repository.model


import com.squareup.moshi.Json

data class Banner(
    @Json(name = "items")
    val items: List<String>? = null,
    @Json(name = "order")
    val order: Int? = null
)