package com.model.modulelib.utils.dagger2.model

import android.content.Context
import com.model.modulelib.data.dp.CommonDP
import com.model.modulelib.utils.dagger2.scope.PerApplication
import com.model.modulelib.view.MyApplication
import dagger.Module
import dagger.Provides

/**
 *  Created tangxin
 *  Time 2018/9/28 下午11:23
 */

@Module
class ApplicationModule(private val mApplication: MyApplication) {

    @Provides
    @PerApplication
    fun provideApplicationContext(): Context = mApplication.applicationContext

    @Provides
    fun provideAssistantApplication(): MyApplication = mApplication

    //DP 示例
    @Provides
    fun provideCommonDP(): CommonDP = CommonDP()

}
