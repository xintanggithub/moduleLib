package com.model.modulelib.model.main

import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import android.view.View
import com.model.modulelib.data.dp.CommonDP
import com.model.modulelib.data.http.ApiStatusDataProvider
import com.model.modulelib.model.base.BaseModelImpl
import com.model.modulelib.utils.ErrorInfo
import com.model.modulelib.utils.ToastUtils
import javax.inject.Inject

/**
 *  Created tangxin
 *  Time 2018/9/29 上午11:52
 */

class MainViewModel @Inject constructor() : BaseModelImpl() {

    @Inject
    lateinit var commonDP: CommonDP
    //状态监听
    var status = MutableLiveData<Boolean>()

    var testName: ObservableField<String> = ObservableField("1111")

    override fun initData() {
        commonDP.getPermission(object : ApiStatusDataProvider<Map<String, String>>(requestStatusLV, apiStatusLv) {
            override fun dataSuccess(result: Map<String, String>) {
                status.value = true
                ToastUtils.showToast("请求成功")
                var content = "success data："
                for (value in result.values) {
                    content += value
                }
                testName.set(content)
            }

            override fun dataEmpty(errorMessage: String) {
                status.value = true
                testName.set("response dataEmpty")
            }

            override fun dataError(errorInfo: ErrorInfo) {
                super.dataError(errorInfo)
                status.value = false
                testName.set("error message: ${errorInfo.message}")
            }
        })
    }

    fun onClick(view: View) {
        ToastUtils.showToast("click")
        testName.set("点击了一次")
    }
}