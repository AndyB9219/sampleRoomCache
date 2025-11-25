# Text Input Saver

A basic Android app that demonstrates using Room database to store and retrieve text input.

## Features

- Text input field for entering text
- Save button to store the text
- Displays the latest saved text below the input field
- Uses Room database for persistent storage
- Implements reactive data flow with Kotlin Coroutines and Flow

## Technical Stack

- **Language**: Kotlin
- **Database**: Room (SQLite)
- **Async**: Kotlin Coroutines
- **Architecture**: Simple Activity-based architecture
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

1. User enters text in the input field
2. Clicks the "Save" button
3. Text is stored in Room database
4. The saved text is automatically displayed below the input field
5. The app uses Flow to observe database changes and update the UI reactively

## Building and Running

1. Open the project in Android Studio
2. Sync Gradle dependencies
3. Run the app on an emulator or physical device

## Dependencies

- AndroidX Core KTX
- AndroidX AppCompat
- Material Components
- Room Database (Runtime, KTX, Compiler)
- Kotlin Coroutines
- Lifecycle Runtime KTX
