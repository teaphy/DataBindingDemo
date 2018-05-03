package com.teaphy.bean

import android.databinding.*
import com.teaphy.BR

class UserBean (var name: String, age: String, sex: Boolean) : BaseObservable(){

	public final val age = ObservableField<String>()


	// 双向绑定
	var sex: Boolean = false
		@Bindable
		get(){
			return field
		}
		set(sex) {
			field = sex
			notifyPropertyChanged(BR.sex)
		}

	init {
		this.sex = sex
		this.age.set(age)
	}

	fun updateAge(age: String) {
		this.age.set(age)
	}

	override fun toString(): String {
		return "UserBean(name='$name', age='$age')"
	}
}