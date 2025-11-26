package com.example.textinputsaver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var database: AppDatabase
    private lateinit var dao: SavedTextDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize database
        database = AppDatabase.getDatabase(this)
        dao = database.savedTextDao()

        setContent {
            TextInputSaverApp(dao = dao, lifecycleScope = lifecycleScope)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInputSaverApp(
    dao: SavedTextDao,
    lifecycleScope: kotlinx.coroutines.CoroutineScope
) {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                Text(
                    text = "Text Input Saver",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 24.dp)
                )

                var textInput by remember { mutableStateOf("") }
                val savedText by dao.getSavedText().collectAsState(initial = null)

                OutlinedTextField(
                    value = textInput,
                    onValueChange = { textInput = it },
                    label = { Text("Enter your text here...") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                Button(
                    onClick = {
                        lifecycleScope.launch {
                            dao.insertText(SavedText(id = 1, text = textInput))
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 32.dp)
                ) {
                    Text("Save")
                }

                Text(
                    text = "Saved Text:",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .defaultMinSize(minHeight = 60.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    )
                ) {
                    Text(
                        text = savedText?.text?.takeIf { it.isNotEmpty() } ?: "No text saved yet.",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        }
    }
}
