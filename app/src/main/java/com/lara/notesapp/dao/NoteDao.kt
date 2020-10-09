package com.lara.notesapp

import androidx.room.*
import com.lara.notesapp.entities.Note

@Dao
interface NoteDao {

    @Query("SELECT * FROm notes ORDER BY id DESC")
    fun getAllNotes(): List<Note>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(newNote: Note)

    @Delete
    fun deleteNote(noteToDelete: Note)

}