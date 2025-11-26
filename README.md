# Text Input Saver

A basic Android app that demonstrates using Room database to store and retrieve text input.

## Features

- Modern UI built with Jetpack Compose and Material3
- Text input field for entering text
- Save button to store the text
- Displays the latest saved text below the input field
- Uses Room database for persistent storage
- Implements reactive data flow with Kotlin Coroutines and Flow
- Real-time UI updates using Compose State

## Technical Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose with Material3
- **Database**: Room (SQLite)
- **Async**: Kotlin Coroutines
- **Architecture**: Simple Activity-based architecture with Compose
- **Min SDK**: 21 (Android 5.0)
- **Target SDK**: 33 (Android 13)

## Project Structure

```
app/
├── src/main/
│   ├── java/com/example/textinputsaver/
│   │   ├── MainActivity.kt         # Main activity with UI logic
│   │   ├── SavedText.kt            # Room entity
│   │   ├── SavedTextDao.kt         # Data Access Object
│   │   └── AppDatabase.kt          # Room database class
│   ├── res/
│   │   ├── layout/
│   │   │   └── activity_main.xml   # UI layout
│   │   └── values/
│   │       ├── strings.xml
│   │       └── colors.xml
│   └── AndroidManifest.xml
└── build.gradle
```

## How It Works

1. User enters text in the Compose OutlinedTextField
2. Clicks the "Save" button
3. Text is stored in Room database using coroutines
4. The saved text is automatically displayed in a Card component below
5. The app uses Flow with Compose's collectAsState() to observe database changes
6. UI updates reactively whenever the database changes

## Building and Running

1. Open the project in Android Studio
2. Sync Gradle dependencies
3. Run the app on an emulator or physical device

## Dependencies

- AndroidX Core KTX
- Jetpack Compose (UI, Material3, Tooling)
- Compose BOM for dependency management
- Activity Compose
- Room Database (Runtime, KTX, Compiler)
- Kotlin Coroutines
- Lifecycle Runtime KTX & Compose
