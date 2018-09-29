package com.model.modulelib.utils

import android.content.Context
import com.model.modulelib.data.sp.BaseSharedPreferencesFactory

/**
 *  Created tangxin
 *  Time 2018/9/29 下午5:08
 */
class SharedPreferencesUtils(context: Context) : BaseSharedPreferencesFactory(context) {

    override val key: String
        get() = "com.model.modulelib"

    companion object {
        // SharedPreferences key
        // demo SharedPreferencesUtils(CommonUtils.sContext!!).setStringValue("key","value")
    }

}