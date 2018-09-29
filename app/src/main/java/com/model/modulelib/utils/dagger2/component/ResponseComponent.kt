package com.model.modulelib.utils.dagger2.component

import com.model.modulelib.data.dp.CommonDP
import com.model.modulelib.utils.dagger2.model.ResponseModule
import dagger.Component

/**
 *  Created tangxin
 *  Time 2018/9/29 上午12:12
 */

@Component(modules = [(ResponseModule::class)])
interface ResponseComponent {

    //    DP示例
    fun inject(commonDP: CommonDP)

}