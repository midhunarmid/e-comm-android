package com.midhunarmid.ecommapp.repository.api

import com.midhunarmid.ecommapp.helper.deliverSingleResult
import com.midhunarmid.ecommapp.helper.processResponse
import com.midhunarmid.ecommapp.repository.model.ResponseData
import io.reactivex.Observable

class APIManager(private val api: RetrofitClientInstance = RetrofitClientInstance()) {
    fun doGetHomeData(): Observable<ResponseData> {
        return Observable.create { subscriber ->
            try {
                val callResponse = api.doGetHomeData()
                val response = callResponse.execute()

                response.processResponse(
                    { result ->
                        subscriber.deliverSingleResult(result)
                    }
                    ,
                    { error ->
                        subscriber.onError(error)
                    }
                )
            } catch (e: Exception) {
                subscriber.onError(e)
            }
        }
    }
}
