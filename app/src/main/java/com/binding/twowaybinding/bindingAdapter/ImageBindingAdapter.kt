package com.binding.twowaybinding.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.squareup.picasso.Picasso

object ImageBindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.loadImage(url: String) {
        Picasso.get().load(url).into(this)
    }

}