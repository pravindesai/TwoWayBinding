package com.binding.twowaybinding

import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.binding.twowaybinding.bindingAdapter.PaymentMethod
import com.binding.twowaybinding.model.Event
import com.binding.twowaybinding.model.User
import com.binding.twowaybinding.rvAdapter.IOnEventListener

class MainActivityViewModel : ViewModel(), IOnEventListener {

    val isChecked: ObservableField<Boolean> = ObservableField<Boolean>()
    val text: ObservableField<String> = ObservableField<String>()
    val paymentMethod: ObservableField<PaymentMethod> = ObservableField<PaymentMethod>()

    val allCountry: ObservableField<List<String>> =
        ObservableField<List<String>>(listOf("India", "US", "Nepal"))
    var selectedCountry: ObservableField<String> = ObservableField<String>()

    var counterValue: ObservableField<Int> = ObservableField<Int>()

    val allUsers: ObservableField<List<User>> = ObservableField<List<User>>()
    var selectedUser: ObservableField<User> = ObservableField<User>()

    var allEvents: ObservableField<MutableList<Event>> = ObservableField(mutableListOf())

    init {

        isChecked.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***", "Check:${isChecked.get()}")
            }
        })
        text.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***", "text :${text.get()}")
            }
        })
        paymentMethod.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***", "text :${paymentMethod.get()}")
            }
        })

        selectedCountry.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***", "text :${selectedCountry.get()}")
            }
        })

        selectedUser.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***", "text :${selectedUser.get()}")
            }
        })

        counterValue.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***", "text :${counterValue.get()}")
            }
        })

        allEvents.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***", "All Events :${allEvents.get()?.size}")
            }
        })
    }

    override fun onClick(event: Event, position: Int) {
        Log.e("***", "Events: $event Pos: $position")
    }

}