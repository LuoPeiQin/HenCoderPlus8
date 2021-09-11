/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: BaseViewHolder
 * Author: lyl
 * Date: 2021/9/9 10:50
 * Description: 用一句话描述下
 */
package com.example.core

import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView

/**
 * @ProjectName: Kotlin
 * @Package: com.example.core
 * @ClassName: BaseViewHolder
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 10:50
 */
open class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val viewHashMap = HashMap<Int, View>()

    fun <T : View> getView(@IdRes id: Int): T {
        var view = viewHashMap[id]
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap[id] = view
        }
        return view as T
    }

    fun setText(@IdRes id: Int, @Nullable text: String?) {
        (getView(id) as TextView).text = text
    }
}