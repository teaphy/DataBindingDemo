package com.teaphy.binding

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions


/**
 * A collection of [BindingAdapter]s for different UI-related tasks.
 *
 * In Kotlin you can write the Binding Adapters in the traditional way:
 *
 * ```
 * @BindingAdapter("property")
 * @JvmStatic fun propertyMethod(view: ViewClass, parameter1: Param1, parameter2: Param2...)
 * ```
 *
 * Or using extension functions:
 *
 * ```
 * @BindingAdapter("property")
 * @JvmStatic fun ViewClass.propertyMethod(parameter1: Param1, parameter2: Param2...)
 * ```
 *
 * See [EditText.clearTextOnFocus].
 *
 * Also, keep in mind that @JvmStatic is only necessary if you define the methods inside a class or
 * object. Consider moving the Binding Adapters to the top level of the file.
 */
object BindingAdapters {

	/*
	 * Instead of having if-else statements in the XML layout, you can create your own binding
	 * adapters, making the layout easier to read.
	 *
	 * Instead of
	 *
	 * `android:visibility="@{viewmodel.isStopped ? View.INVISIBLE : View.VISIBLE}"`
	 *
	 * you use:
	 *
	 * `android:invisibleUnless="@{viewmodel.isStopped}"`
	 *
	 */

	/**
	 * Makes the View [View.INVISIBLE] unless the condition is met.
	 */
	@Suppress("unused")
	@BindingAdapter("invisibleUnless")
	@JvmStatic fun invisibleUnless(view: View, visible: Boolean) {
		view.visibility = if (visible) View.VISIBLE else View.INVISIBLE
	}

	/**
	 * Makes the View [View.GONE] unless the condition is met.
	 */
	@Suppress("unused")
	@BindingAdapter("goneUnless")
	@JvmStatic fun goneUnless(view: View, visible: Boolean) {
		view.visibility = if (visible) View.VISIBLE else View.GONE
	}

	/**
	 * In [ProgressBar], [ProgressBar.setMax] must be called before [ProgressBar.setProgress].
	 * By grouping both attributes in a BindingAdapter we can make sure the order is met.
	 *
	 * Also, this showcases how to deal with multiple API levels.
	 */
	@BindingAdapter(value=["android:max", "android:progress"], requireAll = true)
	@JvmStatic fun updateProgress(progressBar: ProgressBar, max: Int, progress: Int) {
		progressBar.max = max
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			progressBar.setProgress(progress, false)
		} else {
			progressBar.progress = progress
		}
	}

	@BindingAdapter(value = ["bind:imageUrl", "bind:error"])
	@JvmStatic fun loadImage(imageView: ImageView, url: String, error: Drawable) {

		val options = RequestOptions().apply{
			diskCacheStrategy(DiskCacheStrategy.DATA)
			error(error)
		}


		Glide.with(imageView)
				.load(url)
				.apply(options)
				.into(imageView)
	}
}