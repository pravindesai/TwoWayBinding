package com.binding.twowaybinding

data class User(val id:Int, val name: String)
{
    override fun toString(): String {
        return "name: $name"
    }
}
