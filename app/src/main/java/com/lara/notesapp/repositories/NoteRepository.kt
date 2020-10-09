package com.lara.notesapp

import com.lara.notesapp.dao.NoteDao
import com.lara.notesapp.entities.Note

class NoteRepository(private val noteDao: NoteDao) {

    suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

}