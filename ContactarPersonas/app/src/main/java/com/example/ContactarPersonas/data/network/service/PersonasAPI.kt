package com.example.ContactarPersonas.data.network.service

import com.example.ContactarPersonas.data.model.Persona
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonasAPI {

    @GET("users?")
    // usar @query para valores dinamicos (hasta el "?")
   fun getPersona(@Query("page") page:Int): Call<Persona>

}