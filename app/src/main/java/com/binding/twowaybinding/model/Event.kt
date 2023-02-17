package com.binding.twowaybinding.model

import androidx.databinding.BaseObservable

data class Event(var eventName: String, var eventPrice: Double, var eventLocation: String):BaseObservable()
