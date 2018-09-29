package com.model.modulelib.utils

import android.annotation.SuppressLint
import android.os.Handler
import android.widget.Toast

/**
 *  Created tangxin
 *  Time 2018/9/29 下午2:38
 */

object ToastUtils {

    @SuppressLint("ShowToast")
    fun showToast(msg: String?, duration: Long) {
        var toast: Toast? = null
        val handler = Handler()
        val r = Runnable { toast?.cancel() }
        handler.removeCallbacks(r)
        if (toast != null) {
            toast.setText(msg)
        } else {
            toast = Toast.makeText(CommonUtils.sContext, msg, Toast.LENGTH_SHORT)
        }
        handler.postDelayed(r, duration)
        toast?.show()
    }

    fun showToast(msg: String?) {
        showToast(msg, 1500)
    }

    fun showCenterToast(msg: String?) {
        showToast(StringUtils.html2String(msg))
    }

}