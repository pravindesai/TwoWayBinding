package com.binding.twowaybinding.bindingAdapter

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

object RecyclerViewBindingAdapter {
    @JvmStatic
    @BindingAdapter("doubleValueAttrChanged")
    fun EditText.setDoubleValueListener(valueAttrChanged: InverseBindingListener) {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                valueAttrChanged.onChange()
            }
        })
    }

    @JvmStatic
    @BindingAdapter("doubleValue")
    fun EditText.setDoubleValue(value: Double?) {
        if (value != null) {
            val text = value.toString()
            if (text != this.text.toString()) {
                this.setText(text)
            }
        } else {
            if (this.text.isNotEmpty()) {
                this.setText("")
            }
        }
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "doubleValue", event = "doubleValueAttrChanged")
    fun EditText.getDoubleValue(): Double? {
        return text.toString().toDoubleOrNull()
    }

}