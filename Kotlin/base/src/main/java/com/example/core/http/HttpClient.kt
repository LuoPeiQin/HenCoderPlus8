/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: HttpClient
 * Author: lyl
 * Date: 2021/9/9 10:15
 * Description: 用一句话描述下
 */
package com.example.core.http

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type

/**
 * @ProjectName: Kotlin
 * @Package: com.example.core.http
 * @ClassName: HttpClient
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 10:15
 */
object HttpClient : OkHttpClient() {

    private val gson = Gson()

    fun <T> convert(json: String, type: Type): T {
        return gson.fromJson(json, type)
    }

    fun <T> get(path: String, type: Type, entityCallback: EntityCallback<T>) {
        val request = Request.Builder()
                .url("https://api.hencoder.com/$path")
                .build()
        val call = newCall(request)

        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                entityCallback.onFailure("网络异常")
            }

            override fun onResponse(call: Call, response: Response) {
                when (response.code()) {
                    in 200..299 -> {
                        val body = response.body()
                        val json = body!!.string()
                        entityCallback.onSuccess(convert(json, type))
                    }
                    in 400..499 -> {
                        entityCallback.onFailure("客户端错误")
                    }
                    in 500..599 -> {
                        entityCallback.onFailure("服务器错误")
                    }
                    else -> {
                        entityCallback.onFailure("未知错误")
                    }
                }
            }

        })
    }

}