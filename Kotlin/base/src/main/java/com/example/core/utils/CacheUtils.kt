/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: CacheUtils
 * Author: lyl
 * Date: 2021/9/9 10:25
 * Description: 用一句话描述下
 */
package com.example.core.utils

import android.content.Context
import com.example.core.BaseApplication
import com.example.core.R

/**
 * @ProjectName: Kotlin
 * @Package: com.example.core.utils
 * @ClassName: CacheUtils
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 10:25
 */
object CacheUtils {
    val context = BaseApplication.currentApplication

    private val SP = context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    fun save(key: String, value: String) {
        SP.edit().putString(key, value).apply()
    }

    fun get(key: String): String? {
        return SP.getString(key, null)
    }
}