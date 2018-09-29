package com.model.modulelib.data.http

/**
 *  Created tangxin
 *  Time 2018/9/28 下午8:51
 */
//记录接口状态
class ApiStatus(
        //1为畅通,2为绑定异常,3为模块关闭,4为超出登录时间,5 为接口异常,6为其他
        code: String = "1",
        message: String = "无错误信息") : AppStatus(code, message) {
    companion object TYPE {
        const val SUCCESS = "1"

        const val DEFAULT_HANDLE = "0"
        const val SYSTEM_UPDATING = "666" //系统升级中返回的code
        const val NO_LIST_DATA = "8"//暂无列表数据(非错误类型)

        const val API_ERROR = "5"//接口异常
        const val OTHER_ERROR = "6"//其他错误
        const val NET_ERROR = "7"//网络错误
    }
}

open class AppStatus(var code: String,
                     override var message: String) : RuntimeException(message)