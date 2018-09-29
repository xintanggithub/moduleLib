package com.model.modulelib.utils.dagger2.model

import com.model.modulelib.data.api.CommonService
import com.model.modulelib.data.http.RetrofitFactory
import dagger.Module
import dagger.Provides

/**
 *  Created tangxin
 *  Time 2018/9/28 下午11:30
 */

@Module
open class ResponseModule {

    // service 示例
    @Provides
    fun provideCommonService(): CommonService = RetrofitFactory.createService(CommonService::class.java)

}
