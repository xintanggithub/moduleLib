package com.model.modulelib.view.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import com.model.modulelib.utils.LogUtils

/**
 *  Created tangxin
 *  Time 2018/9/28 下午10:53
 */

abstract class BaseSimpleActivity<T : ViewDataBinding> : AppCompatActivity() {

    lateinit var mBinding: T

    private lateinit var pageTitle: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageTitle = this.title.toString()
        mBinding = DataBindingUtil.setContentView(this, getLayoutID())
    }

    //获取布局ID
    abstract fun getLayoutID(): Int

    init {
        //vector兼容性
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    public override fun onPause() {
        super.onPause()
        LogUtils.d("TalkingData退出", pageTitle)
    }

    override fun onResume() {
        super.onResume()
        LogUtils.d("TalkingData进入", pageTitle)
    }

}