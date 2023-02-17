package com.binding.twowaybinding.rvAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binding.twowaybinding.databinding.EventLayoutBinding
import com.binding.twowaybinding.model.Event

class EventsAdapter(
    private val context: Context,
    private val eventsList: MutableList<Event>,
    private val iOnEventListener: IOnEventListener
) :
    RecyclerView.Adapter<EventsAdapter.EventsViewHolder>() {

    inner class EventsViewHolder(val view: EventLayoutBinding) :
        RecyclerView.ViewHolder(view.root) {
        fun bind(event: Event) {
            view.event = event
            view.container.setOnClickListener { iOnEventListener.onClick(event, position = adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventsViewHolder {
        val view = EventLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return EventsViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventsViewHolder, position: Int) {
        val event = eventsList.get(position)
        holder.bind(event)
    }

    override fun getItemCount(): Int = eventsList.size
}
