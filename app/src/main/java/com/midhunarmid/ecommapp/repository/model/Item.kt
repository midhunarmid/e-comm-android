package com.midhunarmid.ecommapp.repository.model


import com.squareup.moshi.Json
data class Item(
    @Json(name = "click_action")
    val clickAction: ClickAction? = null,
    @Json(name = "image")
    val image: String? = null
)