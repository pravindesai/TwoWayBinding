package com.binding.twowaybinding.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField

object CounterAdapter {

    @JvmStatic
    @BindingAdapter("counterTextPlus")
    fun ImageView.bindCounterAdd(value: ObservableField<Int>) {
        setOnClickListener {
            value.set(
                (value.get() ?: 0).plus(1)
            )
        }
    }

    @JvmStatic
    @BindingAdapter("counterTextMinus")
    fun ImageView.bindCounterMinus(value: ObservableField<Int>) {
        setOnClickListener {
            value.set(
                (value.get() ?: 0).minus(1)
            )
        }
    }


}