package com.binding.twowaybinding

import android.widget.RadioGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

object RadioGroupBindingAdapter {

    @JvmStatic
    @BindingAdapter("paymentMethod")
    fun RadioGroup.getPaymentMethod(selectedPaymentMethod:PaymentMethod?){
        val selected = when(selectedPaymentMethod){
            PaymentMethod.OFFLINE-> R.id.rbOffline
            PaymentMethod.ONLINE-> R.id.rbOnline
            else-> null
        }
        selected?.let {
            check(it)
        }
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "paymentMethod", event = "paymentMethodAttrChanged")
    fun RadioGroup.setPaymentMethod(): PaymentMethod? {
        return when (checkedRadioButtonId) {
             R.id.rbOffline -> PaymentMethod.OFFLINE
             R.id.rbOnline -> PaymentMethod.ONLINE
            else-> null
        }
    }

    @JvmStatic
    @BindingAdapter("paymentMethodAttrChanged")
    fun RadioGroup.paymentMethodAttrChangedListener(listener:InverseBindingListener){
        setOnCheckedChangeListener(object :RadioGroup.OnCheckedChangeListener{
            override fun onCheckedChanged(p0: RadioGroup?, p1: Int) {
                listener.onChange()
            }
        })
    }

}

enum class PaymentMethod{
    ONLINE,
    OFFLINE
}