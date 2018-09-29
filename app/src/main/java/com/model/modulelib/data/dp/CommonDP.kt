package com.model.modulelib.data.dp

import com.model.modulelib.data.api.CommonService
import com.model.modulelib.data.http.DataProvider
import rx.Subscription
import javax.inject.Inject

/**
 *  Created tangxin
 *  Time 2018/9/29 下午2:35
 */

class CommonDP @Inject constructor() : BaseDP() {

    override fun inject() {
        resComponent.inject(this)
    }

    @Inject
    lateinit var commonService: CommonService

    fun getPermission(dataProvider: DataProvider<Map<String, String>>): Subscription {
        return getFilterData(commonService.getAllPermission(""), dataProvider)
    }

}