package com.example.ContactarPersonas.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.ContactarPersonas.R
import com.example.ContactarPersonas.data.model.Data
import com.example.ContactarPersonas.databinding.RecyclerViewItemBinding


class AdapterRv : RecyclerView.Adapter<AdapterRv.CuastomViewHolder>() {
    var lista: List<Data> = ArrayList()
    lateinit var listener: onPersonaClickListener

    class CuastomViewHolder(view: View, var listener: onPersonaClickListener) :
        RecyclerView.ViewHolder(view) {

        val binding = RecyclerViewItemBinding.bind(view)

        fun binData(item: Data) {
            with(binding) {
                binding.textView3.text = item.first_name.plus(" ").plus(item.last_name)

                Glide.with(itemView).load(item.avatar).apply(
                    RequestOptions().override(500, 500)
                ).into(binding.imageView2)
                binding.textView.text = item.email

                binding.cvTarjeta.setOnClickListener {
                    listener.onPersonaClick(item)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuastomViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CuastomViewHolder(v, listener)

    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: CuastomViewHolder, position: Int) {
        holder.binData(lista[position])
    }

    fun setPersona(persona: List<Data>) {
        this.lista = persona
        notifyDataSetChanged()
    }

    interface onPersonaClickListener {
        fun onPersonaClick(data: Data)
    }

    fun setOnPersonaClick(listener: onPersonaClickListener) {
        this.listener = listener
    }
}