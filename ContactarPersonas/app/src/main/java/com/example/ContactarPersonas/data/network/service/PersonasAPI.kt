package com.example.ContactarPersonas.data.network.service

import com.example.ContactarPersonas.data.model.Persona
import retrofit2.Call
import retrofit2.http.GET

interface PersonasAPI {
    @GET("users?page=2")
     fun getPersona(): Call<Persona>

}