package com.example.ContactarPersonas.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ContactarPersonas.data.model.Mensaje

@Dao
interface MensajeDao {
    @Insert
     fun agregar(mensaje: Mensaje)

    @Query("select id, nombre, mensaje,id_Personaje from Mensaje")
    fun listar(): LiveData<List<Mensaje>>

    @Query("select id, nombre, mensaje,id_Personaje from Mensaje where id_Personaje=:id")
    fun listarId(id: String): LiveData<List<Mensaje>>

}