/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: MainActivity
 * Author: lyl
 * Date: 2021/9/9 8:46
 * Description: 用一句话描述下
 */
package com.example.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity

/**
 * @ProjectName: Kotlin
 * @Package: com.example.app
 * @ClassName: MainActivity
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 8:46
 */
class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val usernameKey = "username"
    private val passwordKey = "password"

    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etCode: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etUsername = findViewById(R.id.et_username)
        etPassword = findViewById(R.id.et_password)
        etCode = findViewById(R.id.et_code)

        etUsername.setText(CacheUtils.get(usernameKey))
        etPassword.setText(CacheUtils.get(passwordKey))

        val btnLogin: Button = findViewById(R.id.btn_login)
        val imgCode = findViewById<CodeView>(R.id.code_view)
        btnLogin.setOnClickListener(this)
        imgCode.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (v is CodeView) {
//            is 之后，在is生效的范围内，可以不适用as
//            val codeView = v as CodeView
            v.updateCode()
        } else if (v is Button) {
            login()
        }
    }

    private fun login() {
        val username = etUsername.text.toString()
        val password = etPassword.text.toString()
        val code = etCode.text.toString()
        val user = User(username, password, code)
        if (verify(user))
            CacheUtils.save(usernameKey, username)
        CacheUtils.save(passwordKey, password)
        startActivity(Intent(this, LessonActivity::class.java))
    }
}

/**
 * todo
 * 怎么判空是比较好的写法？
 */
fun verify(user: User): Boolean {
    if (user.username?.length ?: 0 < 4) {
        Utils.toast("用户名不合法")
        return false
    }
    if (user.password?.length ?: 0 < 4) {
        Utils.toast("密码不合法")
        return false
    }
    return true
}
