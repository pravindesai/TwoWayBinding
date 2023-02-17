package com.binding.twowaybinding.rvAdapter

import com.binding.twowaybinding.model.Event

interface IOnEventListener {
    fun onClick(event:Event, position:Int)
}