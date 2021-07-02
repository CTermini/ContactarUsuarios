package com.example.ContactarPersonas.ui

import android.app.Application
import com.example.ContactarPersonas.data.repository.MensajeRepo

class AplicationM : Application() {
    companion object {
        lateinit var repo: MensajeRepo
    }

    override fun onCreate() {
        super.onCreate()
        repo = MensajeRepo(this.applicationContext)
    }
}