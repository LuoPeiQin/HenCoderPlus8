/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: Utils
 * Author: lyl
 * Date: 2021/9/9 10:28
 * Description: 用一句话描述下
 */
package com.example.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

/**
 * @ProjectName: Kotlin
 * @Package: com.example.core.utils
 * @ClassName: Utils
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 10:28
 */
object Utils {
    private val displayMetrics = Resources.getSystem().displayMetrics

    fun dp2px(dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
    }

    fun toast(string: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
    }
}