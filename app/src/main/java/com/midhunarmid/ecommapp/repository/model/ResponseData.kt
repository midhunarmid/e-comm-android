package com.midhunarmid.ecommapp.repository.model


import com.squareup.moshi.Json
data class ResponseData(
    @Json(name = "banner")
    val banner: Banner? = null,
    @Json(name = "carousel")
    val carousel: Carousel? = null,
    @Json(name = "products")
    val products: Products? = null
)