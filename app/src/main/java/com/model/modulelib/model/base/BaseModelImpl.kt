package com.model.modulelib.model.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.model.modulelib.data.http.ApiStatus

/**
 *  Created tangxin
 *  Time 2018/9/28 下午11:02
 */
open class BaseModelImpl : ViewModel() {

    companion object {
        const val INIT_LOADING = 1 //初始化加载
        const val REFRESH_LOADING = 2 //刷新加载
        const val REFRESH_FINISH = 3 //刷新完成
        const val LOAD_MORE = 4 //加载更多
        var loadType: Int = INIT_LOADING  //domain事件处理类型
        var requestStatusLV = MutableLiveData<RequestStatus>() //请求状态
        open var observableField = ObservableField<ApiStatus>()
        var apiStatusLv = MutableLiveData<ApiStatus>() //接口状态 （404 success error等）
    }



    init {
        apiStatusLv.value = ApiStatus(ApiStatus.SUCCESS)
        apiStatusLv.observeForever {
            observableField.set(it)
        }
    }

    //定义每个module做主要业务处理的方法,为重试机制暴露接口
    open fun initData() {}

    //需要隐藏的view列表，适用于 接口请求出错，需要变更UI时使用（ps:列表请求出错，list和菜单选项消失，显示错误提示）
    open fun hideViews(): List<Int> {
        return listOf()
    }

}

enum class RequestStatus(val status: Int) {
    REQUEST_BEFORE(0), //请求之前
    REQUEST_SUCCESS(1), //请求成功
    REQUEST_FAILURE(2) //请求失败
}