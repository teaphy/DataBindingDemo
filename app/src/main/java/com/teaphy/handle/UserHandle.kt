package com.teaphy.handle

import android.view.View
import android.widget.Toast
import com.teaphy.bean.UserBean
import java.util.*

class UserHandle {
	/**
	 * 方法引用
	 */
	fun onClickName(view: View) {
		Toast.makeText(view.context, "点击了名称", Toast.LENGTH_SHORT).show()
	}

	/**
	 * 监听绑定
	 */
	fun onClickUser(view: View, userBean: UserBean) {
		Toast.makeText(view.context, "点击: ${userBean.toString()}" , Toast.LENGTH_SHORT).show()
	}

	fun updateUserSex(userBean: UserBean) {
		userBean.sex = !userBean.sex
	}

	fun updateUserAge(userBean: UserBean) {
		val age = Random().nextInt(100)
		userBean.age.set(age.toString())
	}
}