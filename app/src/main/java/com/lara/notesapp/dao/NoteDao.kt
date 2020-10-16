package com.lara.notesapp.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.lara.notesapp.entities.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(newNote: Note)

    @Delete
    suspend fun deleteNote(noteToDelete: Note)

}