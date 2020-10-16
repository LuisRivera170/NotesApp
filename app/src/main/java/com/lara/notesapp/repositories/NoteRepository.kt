package com.lara.notesapp.repositories

import androidx.lifecycle.LiveData
import com.lara.notesapp.dao.NoteDao
import com.lara.notesapp.entities.Note

class NoteRepository(private val noteDao: NoteDao) {

    fun getAllNotes(): LiveData<List<Note>> {
        return noteDao.getAllNotes()
    }

    suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

}