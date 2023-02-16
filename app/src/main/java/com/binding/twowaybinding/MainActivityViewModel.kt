package com.binding.twowaybinding

import android.util.Log
import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel(){

    val isChecked:ObservableField<Boolean> = ObservableField<Boolean>()
    val text:ObservableField<String> = ObservableField<String>()
    val paymentMethod:ObservableField<PaymentMethod> = ObservableField<PaymentMethod>()

    val allCountry:ObservableField<List<String>> = ObservableField<List<String>>(listOf("India","US", "Nepal"))
    var selectedCountry:ObservableField<String> = ObservableField<String>()


    val allUsers:ObservableField<List<User>> = ObservableField<List<User>>()
    var selectedUser:ObservableField<User> = ObservableField<User>()

    init {

        isChecked.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***","Check:${isChecked.get()}")
            }
        })
        text.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***","text :${text.get()}")
            }
        })
        paymentMethod.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***","text :${paymentMethod.get()}")
            }
        })

        selectedCountry.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***","text :${selectedCountry.get()}")
            }
        })

        selectedUser.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                Log.e("***","text :${selectedUser.get()}")
            }
        })


    }

}