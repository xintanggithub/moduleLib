package com.model.modulelib.view.main

import android.arch.lifecycle.Observer
import com.model.modulelib.R
import com.model.modulelib.databinding.ActivityMainBinding
import com.model.modulelib.model.main.MainViewModel
import com.model.modulelib.view.base.BaseActivity
import javax.inject.Inject

/**
 *  Created tangxin
 *  Time 2018/9/28 下午8:07
 */
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    @Inject
    lateinit var model: MainViewModel

    override fun getViewModel() = model

    override fun getLayoutID() = R.layout.activity_main

    override fun inject() {
        mActivityComponent.inject(this)
    }

    override fun initView() {
        model.initData()
//        model.status.observe(this, Observer {
//            when (it) {
//                true -> {
//                }
//                else -> {
//                }
//            }
//        })
    }

}
