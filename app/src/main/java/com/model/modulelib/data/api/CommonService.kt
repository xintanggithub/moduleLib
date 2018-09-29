package com.model.modulelib.data.api

import com.model.modulelib.data.UriConstant.GCommonUri
import com.model.modulelib.data.bean.base.BaseData
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 *  Created tangxin
 *  Time 2018/9/29 下午2:24
 */
interface CommonService {

    @GET(GCommonUri + "getAllPermission")
    fun getAllPermission(@Query("category") categoryName: String): Observable<BaseData<Map<String, String>>>

}