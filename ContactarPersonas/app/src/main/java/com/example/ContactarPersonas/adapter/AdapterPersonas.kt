package com.example.ContactarPersonas.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.ContactarPersonas.R
import com.example.ContactarPersonas.data.model.Mensaje

import com.example.ContactarPersonas.databinding.RecyclerViewItem1Binding

class AdapterPersonas (private var lista: List<Mensaje>): RecyclerView.Adapter<UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_view_item_1, parent, false)
        return UsersViewHolder(v)
    }

    override fun getItemCount(): Int =lista.size

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.binData(lista[position])
    }

    fun setMensaje(mensajes: List<Mensaje>) {
        this.lista = mensajes

        notifyDataSetChanged()
    }
}

