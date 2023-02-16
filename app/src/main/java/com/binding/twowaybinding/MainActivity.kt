package com.binding.twowaybinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.binding.twowaybinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val activityViewModel: MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.apply {
            viewmodel = activityViewModel
        }
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        val users = listOf<User>(
            User(1,"Pravin"),
            User(2,"Akash"),
            User(3,"Vishal"),
        )
        activityViewModel.allUsers.set(users)
    }
}