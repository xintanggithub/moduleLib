package com.model.modulelib.model.main

import android.databinding.ObservableField
import com.model.modulelib.model.base.BaseModelImpl
import javax.inject.Inject

/**
 *  Created tangxin
 *  Time 2018/9/29 上午11:52
 */

class MainViewModel @Inject constructor() : BaseModelImpl() {

    var testName: ObservableField<String> = ObservableField("1111")

    override fun initData() {

    }

}