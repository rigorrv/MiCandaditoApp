package com.example.micandaditoapp.adapter.propiedadesadapter

import android.text.InputFilter
import android.text.InputFilter.LengthFilter
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.example.micandaditoapp.R
import com.example.micandaditoapp.model.DirectionJson
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.direction_items.view.*


class ViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView),
    LayoutContainer {


    // why update ui here? easier to access view without need to holder.titleTextView
    fun bind(
        info: DirectionJson,
        isSelected: Boolean
    ) {
        itemView.direccionRecyclerTxt.text = "$${info.direccion}"
        itemView.precioRecyclerTxt.text = "$${info.pagoMaximo}"
        itemView.masInfoBtn.text = "Info aqui"
        itemView.houseIcon.setBackgroundResource(R.drawable.house0001)
        if (isSelected) {
            itemView.direccionRecyclerTxt.setFilters(arrayOf<InputFilter>(LengthFilter(50)))
            itemView.infoBtn.visibility = View.VISIBLE
        } else {
            itemView.direccionRecyclerTxt.setFilters(arrayOf<InputFilter>(LengthFilter(17)))
            itemView.infoBtn.visibility = View.GONE
        }
    }

    fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
        object : ItemDetailsLookup.ItemDetails<Long>() {
            override fun getPosition(): Int = adapterPosition
            override fun getSelectionKey(): Long? = itemId
            override fun inSelectionHotspot(e: MotionEvent): Boolean {
                return true
            }

            override fun hasSelectionKey(): Boolean {
                return false
            }
        }
}