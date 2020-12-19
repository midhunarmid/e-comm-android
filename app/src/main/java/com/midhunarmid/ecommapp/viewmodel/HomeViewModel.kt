package com.midhunarmid.ecommapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.midhunarmid.ecommapp.helper.Logger
import com.midhunarmid.ecommapp.repository.api.APIManager
import com.midhunarmid.ecommapp.repository.model.ResponseData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val tag: String = "HomeViewModel"
    val mApiResponseLiveData = MutableLiveData<ResponseData>()

    fun doGetHomeData(): Disposable? {
        return APIManager().doGetHomeData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    mApiResponseLiveData.value = result as ResponseData
                    Logger.i(tag, "$result")
                },
                {
                    mApiResponseLiveData.value = ResponseData()
                    Logger.printStackTrace(it)
                }
            )
    }
}
