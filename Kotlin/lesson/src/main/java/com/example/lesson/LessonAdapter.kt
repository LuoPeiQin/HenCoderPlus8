/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: LessonAdapter
 * Author: lyl
 * Date: 2021/9/9 15:24
 * Description: 用一句话描述下
 */
package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseViewHolder
import com.example.lesson.entity.Lesson

/**
 * @ProjectName: Kotlin
 * @Package: com.example.lesson
 * @ClassName: LessonAdapter
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 15:24
 */
class LessonAdapter : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    private var list = listOf<Lesson>()

    fun updateAndNotify(list: List<Lesson>) {
        this.list = list
        notifyDataSetChanged();
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class LessonViewHolder(itemView: View) : BaseViewHolder(itemView) {

        companion object {
            fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_lesson, parent, false))
            }
        }

        fun onBind(lesson: Lesson) {
            setText(R.id.tv_date, lesson.date ?: "日期待定")
            setText(R.id.tv_content, lesson.content)

            lesson.state?.let {
                setText(R.id.tv_state, it.stateName())
                val colorRes = when (it) {
                    Lesson.State.PLAYBACK -> {
                        R.color.playback
                    }
                    Lesson.State.LIVE -> {
                        R.color.live
                    }
                    Lesson.State.WAIT -> {
                        R.color.wait
                    }
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                (getView(R.id.tv_state) as TextView).setBackgroundColor(backgroundColor)
            }
        }
    }

}