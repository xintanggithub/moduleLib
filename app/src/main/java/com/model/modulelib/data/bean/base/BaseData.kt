package com.model.modulelib.data.bean.base

/**
 *  Created tangxin
 *  Time 2018/9/28 下午8:07
 */
open class BaseData<T> {
    var responseCode: String = "-100"
    var responseMessage: String = "消息为null"
    var data: T? = null
}