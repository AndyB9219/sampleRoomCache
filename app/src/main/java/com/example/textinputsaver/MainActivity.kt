package com.example.textinputsaver

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var textInput: EditText
    private lateinit var saveButton: Button
    private lateinit var savedTextView: TextView
    private lateinit var database: AppDatabase
    private lateinit var dao: SavedTextDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize database
        database = AppDatabase.getDatabase(this)
        dao = database.savedTextDao()

        // Initialize views
        textInput = findViewById(R.id.textInput)
        saveButton = findViewById(R.id.saveButton)
        savedTextView = findViewById(R.id.savedTextView)

        // Observe saved text from database
        observeSavedText()

        // Set up save button click listener
        saveButton.setOnClickListener {
            saveText()
        }
    }

    private fun saveText() {
        val text = textInput.text.toString()

        // Save to Room database
        lifecycleScope.launch {
            dao.insertText(SavedText(id = 1, text = text))
        }
    }

    private fun observeSavedText() {
        lifecycleScope.launch {
            dao.getSavedText().collect { savedText ->
                displaySavedText(savedText?.text ?: "")
            }
        }
    }

    private fun displaySavedText(text: String) {
        if (text.isEmpty()) {
            savedTextView.text = "No text saved yet."
        } else {
            savedTextView.text = text
        }
    }
}
