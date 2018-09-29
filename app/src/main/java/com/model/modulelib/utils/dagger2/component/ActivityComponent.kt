package com.model.modulelib.utils.dagger2.component

import com.model.modulelib.utils.dagger2.model.ActivityModule
import com.model.modulelib.utils.dagger2.model.ResponseModule
import com.model.modulelib.utils.dagger2.scope.PerActivity
import com.model.modulelib.view.main.MainActivity
import dagger.Component

/**
 *  Created tangxin
 *  Time 2018/9/28 下午11:17
 */
@PerActivity
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ActivityModule::class), (ResponseModule::class)])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}