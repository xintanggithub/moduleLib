package com.model.modulelib.data.http

import android.arch.lifecycle.MutableLiveData
import com.model.modulelib.model.base.RequestStatus
import com.model.modulelib.utils.ErrorInfo

/**
 *  Created tangxin
 *  Time 2018/9/29 下午3:15
 */
abstract class ApiStatusDataProvider<T : Any?> @JvmOverloads constructor(
        val requestStatus: MutableLiveData<RequestStatus>,
        val apiStatusLv: MutableLiveData<ApiStatus>? = null) : DataProvider<T> {

    override fun beforeRequest() {
        requestStatus.value = RequestStatus.REQUEST_BEFORE
    }

    override fun dataError(errorInfo: ErrorInfo) {
        requestStatus.value = RequestStatus.REQUEST_FAILURE
        if (apiStatusLv?.value?.code != errorInfo.code) {
            apiStatusLv?.value = ApiStatus(errorInfo.code, errorInfo.message ?: "未知错误")
        }
    }

    override fun complete() {
        requestStatus.value = RequestStatus.REQUEST_SUCCESS
        apiStatusLv?.value?.let {
            if (it.code != ApiStatus.SUCCESS && it.code != ApiStatus.NO_LIST_DATA) {
                apiStatusLv.value = ApiStatus(ApiStatus.SUCCESS, "请求成功")
            }
        }
    }

}