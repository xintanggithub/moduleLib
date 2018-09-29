package com.model.modulelib.utils

import com.model.modulelib.BuildConfig

/**
 *  Created tangxin
 *  Time 2018/9/28 下午7:20
 */
class ConfigInfo {

    companion object {

        /**
         * 0 : develop
         * 6 : release
         */
        val LOG_LEVEL = if (BuildConfig.DEBUG) 0 else 6

        /**
         * Channel number
         */
        val sChannel = 0

    }

}
