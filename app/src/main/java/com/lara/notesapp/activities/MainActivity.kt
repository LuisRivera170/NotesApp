package com.lara.notesapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lara.notesapp.R
import kotlinx.android.synthetic.main.activity_main.*

const val REQUEST_CODE_ADD_NOTE = 1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageAddNoteMain.setOnClickListener {
            startActivityForResult(Intent(this, CreateNoteActivity::class.java), REQUEST_CODE_ADD_NOTE)
        }
    }
}