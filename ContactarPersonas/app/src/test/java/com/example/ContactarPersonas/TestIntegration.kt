package com.example.ContactarPersonas

import com.example.ContactarPersonas.core.RetrofitHelper
import com.example.ContactarPersonas.data.network.service.PersonasAPI
import org.junit.Assert.*
import org.junit.Test

class TestIntegration {
    @Test

    fun connection_api() {
        val api = RetrofitHelper.getRetrofit("https://reqres.in/api/")
        val respuesta = api?.getPersona(1)?.execute()
        assertTrue(respuesta?.code() ==200)

    }
}