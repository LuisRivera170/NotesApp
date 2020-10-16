package com.lara.notesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lara.notesapp.dao.NoteDao
import com.lara.notesapp.entities.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}