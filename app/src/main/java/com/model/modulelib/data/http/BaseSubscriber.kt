package com.model.modulelib.data.http

import com.model.modulelib.data.dp.BaseDP
import rx.Subscriber

/**
 *  Created tangxin
 *  Time 2018/9/28 下午8:47
 */
open class BaseSubscriber<T>(private var mDataProvider: DataProvider<T>) : Subscriber<T>() {

    override fun onStart() {
        super.onStart()
        mDataProvider.beforeRequest()
    }

    override fun onCompleted() {
        mDataProvider.complete()
    }

    override fun onError(e: Throwable) {
        mDataProvider.dataError(BaseDP.processError(e))
    }

    override fun onNext(t: T?) {
        if (t != null) {
            mDataProvider.dataSuccess(t)
        } else {
            mDataProvider.dataEmpty("数据为空")
        }
    }

}
