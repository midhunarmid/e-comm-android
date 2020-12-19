package com.midhunarmid.ecommapp.repository.api

import com.midhunarmid.ecommapp.repository.model.ResponseData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class RetrofitClientInstance {
    private val apiInterface: APIInterface
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://api.jsonbin.io"

    private fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
        }
        return retrofit
    }

    init {
        getRetrofitInstance()
        apiInterface = retrofit!!.create(APIInterface::class.java)
    }

    fun doGetHomeData(): Call<ResponseData> {
        return apiInterface.doGetHomeData()
    }
}