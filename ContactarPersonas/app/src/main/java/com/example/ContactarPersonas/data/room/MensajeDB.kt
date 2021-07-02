package com.example.ContactarPersonas.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ContactarPersonas.`data`.model.Mensaje

@Database(entities = [Mensaje::class], version = 1)
abstract class MensajeDB : RoomDatabase() {

    abstract fun mensajeDao(): MensajeDao

    companion object {
        @Volatile
        private var INSTANCE: MensajeDB? = null

        fun getDataBase(context: Context): MensajeDB {
        if (INSTANCE==null){
            synchronized(this){
                INSTANCE= Room.databaseBuilder(context,MensajeDB::class.java,"miDB").build()
            }
        }

            return INSTANCE!!
        }
    }
}