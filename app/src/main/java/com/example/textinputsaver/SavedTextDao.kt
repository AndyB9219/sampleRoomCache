package com.example.textinputsaver

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedTextDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertText(savedText: SavedText)

    @Query("SELECT * FROM saved_text WHERE id = 1")
    fun getSavedText(): Flow<SavedText?>
}
