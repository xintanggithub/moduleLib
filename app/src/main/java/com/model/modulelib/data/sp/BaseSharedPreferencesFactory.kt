package com.model.modulelib.data.sp

import android.content.Context
import android.content.SharedPreferences

/**
 *  Created tangxin
 *  Time 2018/9/29 下午5:05
 */
abstract class BaseSharedPreferencesFactory @JvmOverloads constructor(context: Context, private val mMode: Int = Context.MODE_PRIVATE) {

    private val mContext: Context = context.applicationContext
    private var mSharedPreferences: SharedPreferences? = null

    protected abstract val key: String

    val sharedPreferences: SharedPreferences
        get() {
            if (mSharedPreferences == null) {
                mSharedPreferences = mContext.getSharedPreferences(key, mMode)
            }
            return this.mSharedPreferences!!
        }

    fun clearData() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun setBoolValue(keyName: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(keyName, value)
        editor.apply()
    }

    fun getBoolValue(keyName: String, defValue: Boolean): Boolean {
        val sp = sharedPreferences
        return sp.getBoolean(keyName, defValue)
    }

    fun setStringValue(keyName: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(keyName, value)
        editor.apply()
    }

    fun getStringValue(keyName: String): String? {
        val sp = sharedPreferences
        return sp.getString(keyName, "")
    }

    fun setIntValue(keyName: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(keyName, value)
        editor.apply()
    }

    fun getIntValue(keyName: String, defValue: Int): Int {
        val sp = sharedPreferences
        return sp.getInt(keyName, defValue)
    }
}
