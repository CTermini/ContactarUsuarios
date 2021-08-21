package com.example.ContactarPersonas.core

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ContactarPersonas.databinding.FragmentDejarComentarioBinding
import com.example.ContactarPersonas.databinding.FragmentPersonaBinding
import com.example.ContactarPersonas.databinding.MainFragmentBinding
import com.example.ContactarPersonas.databinding.RecyclerViewItemBinding

object Binding {
    fun getRvBinding(view: View):  RecyclerViewItemBinding {
        return RecyclerViewItemBinding.bind(view)
    }
    fun getPersonaBinding(inflater:LayoutInflater,container:ViewGroup?):FragmentPersonaBinding{
        return  FragmentPersonaBinding.inflate(inflater, container, false)
    }
    fun getComentarioBinding(inflater:LayoutInflater,container:ViewGroup?):FragmentDejarComentarioBinding{
        return  FragmentDejarComentarioBinding.inflate(inflater, container, false)
    }
    fun getMainBinding(inflater:LayoutInflater,container:ViewGroup?):MainFragmentBinding{
        return  MainFragmentBinding.inflate(inflater, container, false)
    }
}