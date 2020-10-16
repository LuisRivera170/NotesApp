package com.lara.notesapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lara.notesapp.R
import kotlinx.android.synthetic.main.activity_create_note.*

class CreateNoteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_note)

        imageBack.setOnClickListener {
            onBackPressed()
        }
    }
}