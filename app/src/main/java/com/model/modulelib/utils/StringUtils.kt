package com.model.modulelib.utils

import android.text.Html
import android.text.TextUtils
import java.util.*
import java.util.regex.Pattern

/**
 *  Created tangxin
 *  Time 2018/9/29 下午2:39
 */

object StringUtils {

    fun html2String(message: String?): String {
        if (!isNotEmpty(message)) {
            return ""
        }
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            Html.fromHtml(message, Html.FROM_HTML_MODE_COMPACT).toString()
        } else {
            Html.fromHtml(message).toString()
        }
    }

    fun isRule(txt: String, regex: String): Boolean {//是否符合规则
        if (!isNotEmpty(txt)) {
            return false
        }
        val mChar = Pattern.compile(regex)
        //存在不符合规则的字符
        return (0 until txt.length)
                .map { mChar.matcher(txt[it].toString()) }
                .any { it.matches() }
    }

    fun isNumber(str: String?): Boolean {
        if (null == str) {
            return false
        }
        var i = str.length
        try {
            while (--i >= 0) {
                val chr = str[i].toInt()
                if (chr < 48 || chr > 57)
                    return false
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
        return true
    }

    //将不规则空格去掉
    fun deleteInvisibleCharacter(oldString: String?): String {
        val p = Pattern.compile("\\s*|\t|\r|\n")
        val m = p.matcher(oldString)
        return m.replaceAll("")
    }

    /**
     * 解析出url参数中的键值对
     * 如 "index.jsp?Action=del&id=123"，解析出Action:del,id:123存入map中
     * @param URL url地址
     * @return url请求参数部分
     */
    fun urlRequest(URL: String): Map<String, String> {
        val mapRequest = HashMap<String, String>()
        val arrSplit: Array<String>
        val strUrlParam = truncateUrlPage(URL) ?: return mapRequest
        //每个键值为一组 www.2cto.com
        arrSplit = strUrlParam.split("[&]".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()
        for (strSplit in arrSplit) {
            var arrSplitEqual: Array<String>? = null
            arrSplitEqual = strSplit.split("[=]".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()

            //解析出键值
            if (arrSplitEqual.size > 1) {
                //正确解析
                mapRequest.put(arrSplitEqual[0], arrSplitEqual[1])

            } else {
                if (arrSplitEqual[0] !== "") {
                    //只有参数没有值，不加入
                    mapRequest.put(arrSplitEqual[0], "")
                }
            }
        }
        return mapRequest
    }

    /**
     * 去掉url中的路径，留下请求参数部分
     * @param strURL url地址
     * @return strAllParam 请求参数部分
     */
    private fun truncateUrlPage(strURL: String): String? {
        var strAllParam: String? = null
        val arrSplit: Array<String> = strURL.split("[?]".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        if (strURL.trim { it <= ' ' }.toLowerCase().length > 1) {
            if (arrSplit.size > 1) {
                strAllParam = arrSplit[1]
            }
        }
        return strAllParam
    }


    /**
     * 判String断是否为空
     */
    fun isNotEmpty(str: String?): Boolean {
        return !(null == str || "" == str || TextUtils.isEmpty(str.trim { it <= ' ' }) || "null" == str)
    }

}