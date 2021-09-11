/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: BaseApplication
 * Author: lyl
 * Date: 2021/9/9 10:43
 * Description: 用一句话描述下
 */
package com.example.core

import android.app.Application
import android.content.Context

/**
 * @ProjectName: Kotlin
 * @Package: com.example.core
 * @ClassName: BaseApplication
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 10:43
 */
class BaseApplication : Application() {

    companion object {
        lateinit var currentApplication: Context
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        currentApplication = this
    }
}