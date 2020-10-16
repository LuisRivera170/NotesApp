package com.lara.notesapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.lara.notesapp.R
import com.lara.notesapp.entities.Note
import com.lara.notesapp.viewmodels.NoteViewModel
import kotlinx.android.synthetic.main.activity_create_note.*
import java.text.SimpleDateFormat
import java.util.*

class CreateNoteActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        imageBack.setOnClickListener {
            onBackPressed()
        }

        // Setting the actual date in textDateTime
        textDateTime.text = SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm a", Locale.getDefault()).format(Date())

        // Save note when click on icon
        imageSave.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        if (inputNoteTitle.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Note title can't be empty!", Toast.LENGTH_SHORT).show()
            return
        } else if (inputNoteSubtitle.text.toString().trim().isEmpty() && inputNoteText.text.toString().trim().isEmpty()) {
            Toast.makeText(this, "Note can't be empty", Toast.LENGTH_SHORT).show()
            return
        }

        val note: Note = Note(title = inputNoteTitle.text.toString(),
                              dateTime = textDateTime.text.toString(),
                              subtitle = inputNoteSubtitle.text.toString(),
                              noteText = inputNoteText.text.toString())

        noteViewModel.insertNote(note)

        val intent = Intent()
        setResult(RESULT_OK, intent)
        finish()
    }

}