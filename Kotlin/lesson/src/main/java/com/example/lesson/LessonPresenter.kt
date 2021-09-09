/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: LessonPresenter
 * Author: lyl
 * Date: 2021/9/9 14:59
 * Description: 用一句话描述下
 */
package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient
import com.example.core.utils.Utils
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

/**
 * @ProjectName: Kotlin
 * @Package: com.example.lesson
 * @ClassName: LessonPresenter
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 14:59
 */
class LessonPresenter {
    private val LESSON_PATH = "lessons"

    private var activity: LessonActivity? = null

    constructor(activity: LessonActivity) {
        this.activity = activity
    }

    private var lessons = listOf<Lesson>()

    private val type: Type = object : TypeToken<List<Lesson>>(){}.type

    fun fetchData() {
        HttpClient.get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(entity: List<Lesson>) {
                this@LessonPresenter.lessons = entity
                activity?.runOnUiThread {
                    activity?.showResult(lessons)
                }
            }

            override fun onFailure(message: String) {
                activity?.runOnUiThread {
                    Utils.toast(message)
                }
            }

        })
    }

    fun showPlayback() {
        val playbackLessons = arrayListOf<Lesson>()
        lessons.forEach {
            if (it.state == Lesson.State.PLAYBACK) {
                playbackLessons.add(it)
            }
        }
        activity?.showResult(playbackLessons)
    }
}