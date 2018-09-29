package com.model.modulelib.view.base

import android.databinding.ViewDataBinding
import android.os.Bundle
import com.model.modulelib.BR
import com.model.modulelib.model.base.BaseModelImpl
import com.model.modulelib.utils.dagger2.component.ActivityComponent
import com.model.modulelib.utils.dagger2.component.DaggerActivityComponent
import com.model.modulelib.utils.dagger2.model.ActivityModule
import com.model.modulelib.view.MyApplication

/**
 *  Created tangxin
 *  Time 2018/9/28 下午10:59
 */

abstract class BaseActivity<T : ViewDataBinding, out E : BaseModelImpl> : BaseSimpleActivity<T>() {

    lateinit var mActivityComponent: ActivityComponent

    //获取viewModel
    abstract fun getViewModel(): E

    //注入数据
    abstract fun inject()

    //初始化view
    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActivityComponent()
        inject()
        mBinding.setVariable(BR.viewModel, getViewModel())
        mBinding.executePendingBindings()
        initView()
    }

    private fun initActivityComponent() {
        mActivityComponent = DaggerActivityComponent.builder()
                .applicationComponent(MyApplication.mApplicationComponent)
                .activityModule(ActivityModule(this))
                .build()
    }


}