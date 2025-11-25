package com.example.textinputsaver

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_text")
data class SavedText(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 1, // Always use ID 1 to keep only the latest text
    val text: String
)
