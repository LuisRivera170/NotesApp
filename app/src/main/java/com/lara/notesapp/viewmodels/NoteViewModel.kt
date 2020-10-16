package com.lara.notesapp.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lara.notesapp.repositories.NoteRepository
import com.lara.notesapp.database.AppDatabase
import com.lara.notesapp.entities.Note
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private val noteRepository: NoteRepository

    init {
        val noteDao = AppDatabase.getDatabase(application).noteDao()
        noteRepository = NoteRepository(noteDao)
    }

    fun getAllNotes(): LiveData<List<Note>> {
        return noteRepository.getAllNotes()
    }

    fun insertNote(note: Note) = viewModelScope.launch {
        noteRepository.insertNote(note)
    }

}