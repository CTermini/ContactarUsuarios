package com.example.ContactarPersonas.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ContactarPersonas.core.RetrofitHelper
import com.example.ContactarPersonas.data.model.Data
import com.example.ContactarPersonas.data.model.Mensaje
import com.example.ContactarPersonas.data.model.Persona
import com.example.ContactarPersonas.data.network.service.PersonasAPI
import com.example.ContactarPersonas.ui.AplicationM
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainViewModel : ViewModel() {

    private val service: PersonasAPI = RetrofitHelper.getRetrofit("https://reqres.in/api/")!!

    val listaUsr = MutableLiveData<List<Data>>()

    val isLoadingProgressBar = MutableLiveData<Boolean>()

    val mensaje: LiveData<List<Mensaje>>

    init {

        mensaje = AplicationM.repo.listar()
    }

    fun obtenerUsuarios() {
        isLoadingProgressBar.postValue(true)

        val call = service.getPersona(2) // buscar como reemplazarlo
        call.enqueue(object : Callback<Persona> {

            override fun onFailure(call: Call<Persona>, t: Throwable) {
                call.cancel()
            }

            override fun onResponse(call: Call<Persona>, response: Response<Persona>) {

                if (call.isExecuted) {
                    if (response.body() != null) {
                        response.body().let {
                            listaUsr.postValue(it?.data)?: emptyList()
                            isLoadingProgressBar.postValue(false)
                        }
                    }
                }
            }
        })

    }


    fun onAgregarClicked(mensaje: Mensaje) {
        AplicationM.repo.agregar(mensaje)

    }

    fun onListarId(id: String): LiveData<List<Mensaje>> {

        return AplicationM.repo.listarId(id)

    }

}
