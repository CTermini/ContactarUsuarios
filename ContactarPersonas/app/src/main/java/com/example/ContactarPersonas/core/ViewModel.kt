package com.example.ContactarPersonas.core

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.example.ContactarPersonas.ui.main.MainViewModel

object ViewModel {
    fun getViewModel(vm:ViewModelStoreOwner): MainViewModel {
        return ViewModelProvider(vm).get(MainViewModel::class.java)
    }
}