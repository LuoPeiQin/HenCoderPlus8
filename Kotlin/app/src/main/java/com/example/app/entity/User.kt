/**
 * Copyright (C), 2007-2021, 未来穿戴有限公司
 * FileName: User
 * Author: lyl
 * Date: 2021/9/9 9:15
 * Description: 用一句话描述下
 */
package com.example.app.entity

/**
 * @ProjectName: Kotlin
 * @Package: com.example.app.entity
 * @ClassName: User
 * @Description: 用一句话描述下
 * @Author: lpq
 * @CreateDate: 2021/9/9 9:15
 */
class User {
    var username: String? = null
    var password: String? = null
    var code: String? = null

    constructor() {

    }

    constructor(username: String, password: String, code: String) {
        this.username = username
        this.password = password
        this.code = code
    }

}