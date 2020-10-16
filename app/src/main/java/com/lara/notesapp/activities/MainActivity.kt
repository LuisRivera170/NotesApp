package com.lara.notesapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.lara.notesapp.R
import com.lara.notesapp.viewmodels.NoteViewModel
import kotlinx.android.synthetic.main.activity_main.*

const val REQUEST_CODE_ADD_NOTE = 1

class MainActivity : AppCompatActivity() {

    private lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View model initialization
        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        noteViewModel.getAllNotes()

        // Observe notes
        noteViewModel.getAllNotes().observe(this, { notes ->
            notes.let {
                Log.d("MainActivity", it.toString())
            }
        })

        // Add note click
        imageAddNoteMain.setOnClickListener {
            startActivityForResult(Intent(this, CreateNoteActivity::class.java), REQUEST_CODE_ADD_NOTE)
        }

    }
}