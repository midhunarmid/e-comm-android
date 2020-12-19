package com.midhunarmid.ecommapp.repository.model


import com.squareup.moshi.Json
data class Products(
    @Json(name = "items")
    val items: List<Item>? = null,
    @Json(name = "order")
    val order: Int? = null
)