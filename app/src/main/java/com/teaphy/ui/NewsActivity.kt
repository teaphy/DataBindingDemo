package com.teaphy.ui

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.teaphy.R
import com.teaphy.adapter.NewsAdapter
import com.teaphy.bean.NewsBean
import com.teaphy.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {

	var newsBinding: ActivityNewsBinding? = null

	var rvNews : RecyclerView? = null

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		newsBinding = DataBindingUtil.setContentView(this, R.layout.activity_news)
		rvNews = newsBinding?.rvNews

		val list = mutableListOf<NewsBean>()
		val imgUrl = "https://t11.baidu.com/it/u=2099966164,1260770283&fm=173&app=25&f=JPEG?w=531&h=382&s=C58A28BEEA2264940F3B22B303008006"
		val title = "中多建交天经地义，光明正大， 扯不上什么诱迫和交易！"
		val content = "【环球网综合报道】“外交部发言人办公室”公众号(xws4_fmprc)消息，在5月2日外交部例行记者会上，有记者问及：台湾方面宣称，大陆以巨额金援诱迫多米尼加同台“断交”。请问发言人有何评论？"
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean("", title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean("", title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))
		list.add(NewsBean(imgUrl, title, content))

		rvNews?.apply {
			layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
			adapter = NewsAdapter(list)
			addItemDecoration(DividerItemDecoration(this@NewsActivity, DividerItemDecoration.VERTICAL))
		}
	}
}
