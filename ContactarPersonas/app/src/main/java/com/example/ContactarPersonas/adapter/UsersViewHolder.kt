package com.example.ContactarPersonas.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.ContactarPersonas.data.model.Mensaje
import com.example.ContactarPersonas.databinding.RecyclerViewItem1Binding

class UsersViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = RecyclerViewItem1Binding.bind(view)

    fun binData(item: Mensaje) {
        with(binding) {

            tvNombre.text = (item.nombre)
            tvMensaje.text = (item.mensaje)



        }
    }

}