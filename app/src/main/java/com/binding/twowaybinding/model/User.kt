package com.binding.twowaybinding.model

data class User(val id:Int, val name: String)
{
    override fun toString(): String {
        return "name: $name"
    }
}
