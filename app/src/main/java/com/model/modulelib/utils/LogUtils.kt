package com.model.modulelib.utils

import android.text.TextUtils
import android.util.Log

import com.model.modulelib.utils.ConfigInfo.Companion.LOG_LEVEL

/**
 * Created by tangxin on 2018/9/28.
 */
object LogUtils {
    fun v(tag: String, message: String) {
        var msg = message
        if (Log.VERBOSE >= LOG_LEVEL) {
            msg = if (TextUtils.isEmpty(msg)) "错误消息为null" else msg
            Log.v(tag, msg)
        }
    }

    fun d(tag: String, message: String) {
        var msg = message
        if (Log.DEBUG >= LOG_LEVEL) {
            msg = if (TextUtils.isEmpty(msg)) "错误消息为null" else msg
            Log.d(tag, msg)
        }
    }

    fun i(tag: String, message: String) {
        var msg = message
        if (Log.INFO >= LOG_LEVEL) {
            msg = if (TextUtils.isEmpty(msg)) "错误消息为null" else msg
            Log.i(tag, msg)
        }
    }

    fun w(tag: String, message: String) {
        var msg = message
        if (Log.WARN >= LOG_LEVEL) {
            msg = if (TextUtils.isEmpty(msg)) "错误消息为null" else msg
            Log.w(tag, msg)
        }
    }

    fun e(tag: String, message: String) {
        var msg = message
        if (Log.ERROR >= LOG_LEVEL) {
            msg = if (TextUtils.isEmpty(msg)) "错误消息为null" else msg
            Log.e(tag, msg)
        }
    }

    fun e(tag: String, message: String, ex: Throwable) {
        var msg = message
        if (Log.ERROR >= LOG_LEVEL) {
            msg = if (TextUtils.isEmpty(msg)) "错误消息为null" else msg
            Log.e(tag, msg, ex)
        }
    }
}
