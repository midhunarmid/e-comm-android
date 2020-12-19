package com.midhunarmid.ecommapp.repository.api

import com.midhunarmid.ecommapp.repository.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET

interface APIInterface {
    @GET("/b/5fdd9ed3e3d1c53225093bbb")
    fun doGetHomeData(): Call<ResponseData>
}