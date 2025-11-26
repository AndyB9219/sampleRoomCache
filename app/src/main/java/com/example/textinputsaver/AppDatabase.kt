package com.example.textinputsaver

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [SavedText::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun savedTextDao(): SavedTextDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "text_input_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
