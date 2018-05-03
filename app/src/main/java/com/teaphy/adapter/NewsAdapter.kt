package com.teaphy.adapter

import android.databinding.DataBindingUtil
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.teaphy.BR
import com.teaphy.R
import com.teaphy.bean.NewsBean
import com.teaphy.databinding.ItemNewsBinding

class NewsAdapter(val mList: MutableList<NewsBean>) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
		val binding: ItemNewsBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_news, parent, false)
		return MyViewHolder(binding.root)
	}

	override fun getItemCount(): Int {
		return mList.size
	}

	override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
		val binding: ItemNewsBinding? = DataBindingUtil.getBinding<ItemNewsBinding>(holder.itemView)
		binding?.apply {
			setVariable(BR.newsBean, mList[position])
			executePendingBindings()
		}

	}

	class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)

}