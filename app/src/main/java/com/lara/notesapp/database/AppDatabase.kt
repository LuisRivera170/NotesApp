package com.lara.notesapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lara.notesapp.NoteDao
import com.lara.notesapp.entities.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun noteDao(): NoteDao

}