/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: Lesson
 * Author: lyl
 * Date: 2021/9/9 15:15
 * Description: 用一句话描述下
 */
package com.example.lesson.entity

/**
 * @ProjectName: Kotlin
 * @Package: com.example.lesson.entity
 * @ClassName: Lesson
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 15:15
 */
class Lesson(var date: String?,var content: String?,var state: State?) {
    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },

        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },

        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String
    }

}