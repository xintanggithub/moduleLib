package com.model.modulelib.data.http

import com.model.modulelib.utils.ErrorInfo

/**
 *  Created tangxin
 *  Time 2018/9/28 下午8:44
 */
interface DataProvider<T> {
    //数据请求之前
    fun beforeRequest()

    //请求成功
    fun dataSuccess(result: T)

    //请求失败
    fun dataError(errorInfo: ErrorInfo)

    //请求完成
    fun complete()

    //请求成功 数据为空
    fun dataEmpty(errorMessage: String)
}