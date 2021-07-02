package com.example.ContactarPersonas.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Mensaje(
    @PrimaryKey(autoGenerate = true) var id: Int,
    var nombre: String,
    var mensaje: String,
    var id_Personaje: String
)