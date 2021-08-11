package com.example.micandaditoapp.adapter.propiedadesadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.example.micandaditoapp.R
import com.example.micandaditoapp.model.DirectionJson

class PropidadesAdapter : RecyclerView.Adapter<ViewHolder>() {

    var info = listOf<DirectionJson>()

    fun getInfo(list: List<DirectionJson>) {
        info = list
    }

    var tracker: SelectionTracker<Long>? = null

    init {
        setHasStableIds(true)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        tracker?.let {
            holder.bind(info[position], it.isSelected(position.toLong()))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.direction_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = info.size

    override fun getItemId(position: Int): Long = position.toLong()

}
