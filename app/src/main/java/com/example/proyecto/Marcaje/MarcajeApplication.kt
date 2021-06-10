package com.example.proyecto.Marcaje

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class MarcajeApplication: Application() {
    companion object {
        lateinit var database: MarcajesDatabase
    }

    override fun onCreate() {
        super.onCreate()

        val MIGRATION_1_2=object : Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE MarcajesEntity ADD COLUMN photoUrl TEXT NOT NULL DEFAULT''")
            }
        }

        database = Room.databaseBuilder(this, MarcajesDatabase::class.java,
            "MarcajesDatabase")
            .addMigrations(MIGRATION_1_2)
            .build()
    }
}
