/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: EntityCallback
 * Author: lyl
 * Date: 2021/9/9 10:14
 * Description: 用一句话描述下
 */
package com.example.core.http

import androidx.annotation.NonNull
import androidx.annotation.Nullable

/**
 * @ProjectName: Kotlin
 * @Package: com.example.core.http
 * @ClassName: EntityCallback
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 10:14
 */
interface EntityCallback<T> {
    fun onSuccess(@NonNull entity: T)

    fun onFailure(@Nullable message: String)
}