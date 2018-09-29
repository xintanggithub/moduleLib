package com.model.modulelib.data.dp

import com.google.gson.Gson
import com.model.modulelib.BuildConfig
import com.model.modulelib.data.bean.base.BaseData
import com.model.modulelib.data.http.ApiStatus
import com.model.modulelib.data.http.BaseSubscriber
import com.model.modulelib.data.http.DataProvider
import com.model.modulelib.utils.ErrorInfo
import com.model.modulelib.utils.LogUtils
import retrofit2.adapter.rxjava.HttpException
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Func1
import rx.schedulers.Schedulers
import java.net.ConnectException
import java.net.URL
import java.net.UnknownHostException

/**
 *  Created tangxin
 *  Time 2018/9/28 下午8:07
 */
class BaseDP {

    //对基类数据进行过滤处理
    fun <T> getFilterData(observable: Observable<BaseData<T>>, provider: DataProvider<T>): Subscription {
        return observable
                .subscribeOn(Schedulers.io())
                .flatMap(GetResultFilter())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(BaseSubscriber(provider))
    }

    //根据完整的请求地址进行请求
    inline fun <reified T> sendHttpRequest(url: String, provider: DataProvider<T>) {
        Observable.just(url)
                .subscribeOn(Schedulers.io())
                .map { Gson().fromJson(URL(it).readText(), T::class.java) }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(BaseSubscriber(provider))
    }

    fun <T> getExternalNoErrorHintData(observable: Observable<T>, provider: DataProvider<T>): Subscription {
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(BaseSubscriber(provider))
    }

    //数据处理放在子线程 数据类型不需要ApiStatus监控
    fun <T> getDataFromIo(observable: Observable<BaseData<T>>, provider: DataProvider<T>): Subscription {
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(GetResultFilter())
                .subscribe(BaseSubscriber(provider))
    }

    class GetResultFilter<T> : Func1<BaseData<T>, Observable<T>> {
        override fun call(baseData: BaseData<T>): Observable<T>? {
            val code = baseData.responseCode
            val apiStatus = ApiStatus(code, baseData.responseMessage)
            return if (code == ApiStatus.TYPE.SUCCESS) Observable.just(baseData.data) else Observable.error(apiStatus)
        }
    }

    companion object {
        fun processError(e: Throwable): ErrorInfo {
            LogUtils.e("retrofit", e.message ?: "错误消息为null")
            val errorInfo = when (e) {
                is ConnectException, is UnknownHostException, is HttpException -> {
                    ErrorInfo(ApiStatus.NET_ERROR, "网络错误")
                }
                is ApiStatus -> {
                    if (listOf(ApiStatus.SYSTEM_UPDATING,
                                    ApiStatus.NO_LIST_DATA).contains(e.code)) {
                        ErrorInfo(e.code, e.message)
                    } else {
                        ErrorInfo(ApiStatus.API_ERROR, e.message)
                    }
                }
                else -> {
                    return if (BuildConfig.DEBUG) {
                        ErrorInfo(ApiStatus.OTHER_ERROR, e.message ?: "未知错误")
                    } else {
                        ErrorInfo(ApiStatus.OTHER_ERROR, "系统错误")
                    }
                }

            }
            Observable.just(errorInfo.message).observeOn(AndroidSchedulers.mainThread()).subscribe {
                when (errorInfo.code) {
                    //todo 根据code区分错误类型 并且返回回去
                }
            }
            return errorInfo
        }
    }

}