package com.model.modulelib.utils.dagger2.component

import com.model.modulelib.utils.dagger2.model.ApplicationModule
import com.model.modulelib.utils.dagger2.scope.PerApplication
import com.model.modulelib.view.MyApplication
import dagger.Component

/**
 *  Created tangxin
 *  Time 2018/9/28 下午11:21
 */

@PerApplication
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {
    fun inject(application: MyApplication)
}