package com.example.ContactarPersonas.core

import com.example.ContactarPersonas.data.network.service.PersonasAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(url:String): PersonasAPI? {
        return Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create()).build().create(PersonasAPI::class.java)
    }


}