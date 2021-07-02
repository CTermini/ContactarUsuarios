package com.example.ContactarPersonas.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.ContactarPersonas.data.model.Mensaje
import com.example.ContactarPersonas.data.room.MensajeDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MensajeRepo(var context: Context) {
    var miDb = MensajeDB.getDataBase(context)

    fun agregar(mensaje: Mensaje) {
        CoroutineScope(IO).launch {
            miDb.mensajeDao().agregar(mensaje)
        }
    }

    fun listar(): LiveData<List<Mensaje>> {
        return miDb.mensajeDao().listar()
    }

    fun listarId( id:String): LiveData<List<Mensaje>> {
        Log.i("Listardi", "listarId: ")
        return miDb.mensajeDao().listarId(id)
    }
}