package com.midhunarmid.ecommapp.repository.model


import com.squareup.moshi.Json

data class Item(
    @Json(name = "click_action")
    val clickAction: ClickAction? = null,
    @Json(name = "image")
    val image: String? = null,
    @Json(name = "subtitle")
    val subtitle: String? = null,
    @Json(name = "title")
    val title: String? = null
)