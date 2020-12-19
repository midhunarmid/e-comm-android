package com.midhunarmid.ecommapp.helper

import com.midhunarmid.ecommapp.BuildConfig
import com.midhunarmid.ecommapp.repository.model.ErrorResponse
import io.reactivex.ObservableEmitter
import org.json.JSONObject
import retrofit2.Response

/**
 * Wrapping try/catch to ignore catch block
 */
inline fun <T> justTry(block: () -> T) = try {
    block()
} catch (e: Throwable) {
    Logger.printStackTrace(e)
}

/**
 * App's debug mode
 */
inline fun debugMode(block: () -> Unit) {
    if (BuildConfig.DEBUG) {
        block()
    }
}


fun <T> ObservableEmitter<T>.deliverSingleResult(value: T) {
    onNext(value)
    onComplete()
}

fun <T> Response<T>.processResponse(
    success: (data: T) -> Unit,
    failure: (error: ErrorResponse) -> Unit
) {
    if (isSuccessful) {
        val result = body()
        if (result != null) {
            Logger.v("success", result.toString())
            success(result)
        } else {
            failure(ErrorResponse())
        }
    } else {
        val errorString = errorBody()?.string()
        Logger.e("failure", errorString)

        try {
            val error = JSONObject(errorString)
            failure(
                ErrorResponse(
                    error.optString("error"),
                    error.optString("message"),
                    error.optInt("status")
                )
            )
        } catch (e: Exception) {
            failure(ErrorResponse())
        }
    }
}