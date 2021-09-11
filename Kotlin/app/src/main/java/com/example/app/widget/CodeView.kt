/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: CodeView
 * Author: lyl
 * Date: 2021/9/9 9:18
 * Description: 用一句话描述下
 */
package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.annotation.Nullable
import androidx.appcompat.widget.AppCompatTextView
import com.example.app.R
import com.example.core.utils.Utils
import java.util.*

/**
 * @ProjectName: Kotlin
 * @Package: com.example.app.widget
 * @ClassName: CodeView
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 9:18
 */
class CodeView(context: Context, @Nullable attrs: AttributeSet? = null) : AppCompatTextView(context, attrs) {

    private val paint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.STROKE
        color = getContext().getColor(R.color.colorAccent)
        strokeWidth = Utils.dp2px(6f)
    }

    private val codeList = arrayOf(
            "kotlin",
            "android",
            "java",
            "http",
            "https",
            "okhttp",
            "retrofit",
            "tcp/ip"
    )

    init {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity = Gravity.CENTER
        setBackgroundColor(getContext().getColor(R.color.colorPrimary))
        setTextColor(Color.WHITE)
        updateCode()
    }

    fun updateCode() {
        val random = Random().nextInt(codeList.size)
        val code = codeList[random]
        text = code
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint)
        super.onDraw(canvas)
    }


}