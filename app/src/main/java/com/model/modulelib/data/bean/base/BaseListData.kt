package com.model.modulelib.data.bean.base

/**
 *  Created tangxin
 *  Time 2018/9/28 下午8:07
 */
class BaseListData<T> {
    var list: List<T> = listOf()
    var totalCount: Int = 0
}