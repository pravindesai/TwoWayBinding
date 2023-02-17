package com.binding.twowaybinding

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.databinding.ObservableField

object SpinnerBindingAdapter {


    @JvmStatic
    @BindingAdapter(
        "allItems",
        "selectedItem",
        requireAll = false
    )
    fun <T> Spinner.setCountries(
        allItems: ObservableField<List<T>>,
        selectedItem: ObservableField<T>,
    ) {
        adapter = ArrayAdapter(
            context,
            android.R.layout.simple_spinner_dropdown_item,
            allItems.get() ?: listOf()
        )

        val selection = allItems.get()?.indexOf(selectedItem.get())
        selection?.let { setSelection(it) }

        onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedItem.set(allItems.get()?.getOrNull(position))
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

    }

    @Suppress("UNCHECKED_CAST")
    @JvmStatic
    @InverseBindingAdapter(attribute = "selectedItem", event = "selectedValueAttrChanged")
    fun <T> Spinner.setSelectedCountry(): T? {
        return selectedItem as? T
    }

    @JvmStatic
    @BindingAdapter("selectedValueAttrChanged")
    fun Spinner.setSelectedValueListener(listener: InverseBindingListener?) {

        onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                listener?.onChange()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                listener?.onChange()
            }
        }
    }
}