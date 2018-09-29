package com.model.modulelib.utils.dagger2.model

import android.support.v7.app.AppCompatActivity
import com.model.modulelib.utils.dagger2.scope.PerActivity
import dagger.Module
import dagger.Provides

/**
 *  Created tangxin
 *  Time 2018/9/28 下午11:23
 */

@Module
class ActivityModule(val activity: AppCompatActivity) {
}