package com.teaphy.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.teaphy.R
import com.teaphy.bean.UserBean
import com.teaphy.databinding.ActivityMainBinding
import com.teaphy.handle.UserHandle
import com.teaphy.view.MainView
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity(), MainView {
	override fun startNewsActivity(view: View) {
		startActivity<NewsActivity>()
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
//		setContentView(R.layout.activity_main)

		val mainBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
		mainBinding.user = UserBean("teaphy", "20", false)
		mainBinding.handlers = UserHandle()
		mainBinding.mainViews = this
	}
}
