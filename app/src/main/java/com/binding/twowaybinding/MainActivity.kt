package com.binding.twowaybinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.binding.twowaybinding.databinding.ActivityMainBinding
import com.binding.twowaybinding.model.Event
import com.binding.twowaybinding.model.User
import com.binding.twowaybinding.rvAdapter.EventsAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val activityViewModel: MainActivityViewModel by viewModels()
    var eventAdapter: EventsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        eventAdapter = EventsAdapter(
            this@MainActivity,
            activityViewModel.allEvents.get() ?: mutableListOf(),
            activityViewModel
        )
        binding.apply {
            viewmodel = activityViewModel
            eventsAdapter = eventAdapter
        }
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        val users = listOf<User>(
            User(1, "Pravin"),
            User(2, "Akash"),
            User(3, "Vishal"),
        )
        activityViewModel.allUsers.set(users)

        val events = listOf<Event>(
            Event("Club1", 1.11, "Pune"),
            Event("Club2", 2.11, "Pune"),
            Event("Club3", 3.11, "Pune"),
        )
        activityViewModel.allEvents.get()?.addAll(events)
        eventAdapter?.notifyDataSetChanged()
    }
}