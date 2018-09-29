package com.model.modulelib.utils.dagger2.component

import com.model.modulelib.utils.dagger2.model.ActivityModule
import com.model.modulelib.utils.dagger2.model.ResponseModule
import com.model.modulelib.utils.dagger2.scope.PerActivity
import com.model.modulelib.utils.dagger2.scope.PerFragment
import dagger.Component

/**
 *  Created tangxin
 *  Time 2018/9/29 上午12:11
 */

@PerFragment
@Component(dependencies = [(ApplicationComponent::class)], modules = [(ActivityModule::class), (ResponseModule::class)])
interface FragmentComponent {

    // fragment示例
    // fun inject(mineFragment: MineFragment)

}