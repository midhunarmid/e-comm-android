package com.midhunarmid.ecommapp.repository.model

import com.squareup.moshi.Json

class ResponseItem(
    @Json(name = "order")
    val order: Int? = null
) {
}