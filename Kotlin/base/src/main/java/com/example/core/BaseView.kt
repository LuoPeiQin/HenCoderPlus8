package com.example.core

/**
 * @ProjectName: Kotlin
 * @Package: com.example.core
 * @ClassName: BaseView
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 10:32
 */
interface BaseView<T> {
    fun getPresenter(): T
}