package com.model.modulelib.view

import android.app.Application
import com.model.modulelib.utils.CommonUtils
import com.model.modulelib.utils.LogUtils
import com.model.modulelib.utils.dagger2.component.ApplicationComponent
import com.model.modulelib.utils.dagger2.component.DaggerApplicationComponent
import com.model.modulelib.utils.dagger2.model.ApplicationModule

/**
 *  Created tangxin
 *  Time 2018/9/28 下午11:25
 */

open class MyApplication : Application() {

    companion object {
        var TAG = "MyApplication"
        lateinit var mApplicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        CommonUtils.sContext = getApplicationContext()
        initApplicationComponent()
        mApplicationComponent.inject(this)

    }

    private fun initApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .apply {
                    applicationModule(ApplicationModule(this@MyApplication))
                }
                .build()
    }


    override fun onTerminate() {
        LogUtils.d(TAG, "程序终止的时候执行:====>AssistantApplication:------>onTerminate")
        super.onTerminate()
    }

    override fun onLowMemory() {
        LogUtils.d(TAG, "低内存的时候执行:====>AssistantApplication:------>onLowMemory")
        super.onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        LogUtils.d(TAG, "程序在内存清理的时候执行:====>AssistantApplication:------>onTrimMemory:___>level:>$level")
        super.onTrimMemory(level)
    }

}