# Android Studio Setup Instructions

If you're seeing Gradle errors about `module()` method not found, follow these steps:

## Step 1: Close Android Studio
Close Android Studio completely if it's open.

## Step 2: Delete Cache Directories
Delete these directories from the project:
```bash
rm -rf .gradle/
rm -rf .idea/
rm -rf app/build/
rm -rf build/
```

Or on Windows:
```cmd
rmdir /s /q .gradle
rmdir /s /q .idea
rmdir /s /q app\build
rmdir /s /q build
```

## Step 3: Delete Android Studio Caches
In Android Studio, go to:
- **File → Invalidate Caches / Restart**
- Select "Invalidate and Restart"

## Step 4: Open Project Fresh
1. Open Android Studio
2. Select "Open an Existing Project"
3. Navigate to this project directory
4. Click OK

## Step 5: Wait for Initial Sync
- Android Studio will automatically start syncing
- It will download the Android SDK if needed
- It will download all Gradle dependencies
- This may take several minutes on first sync

## Step 6: If Sync Still Fails
1. Go to **File → Project Structure**
2. Verify:
   - **Android Gradle Plugin Version**: 8.0.2
   - **Gradle Version**: 8.0
   - **JDK**: Java 11 or higher

3. Try sync again

## Common Issues

### "Plugin not found" errors
- Make sure you have internet connection
- Android Studio needs to download plugins from Google's Maven repository

### "SDK not found" errors
- Go to **File → Settings → Appearance & Behavior → System Settings → Android SDK**
- Install Android SDK Platform 33
- Install Android SDK Build Tools

### Still having issues?
Try these nuclear options:
1. Delete `~/.gradle/` directory (your global Gradle cache)
2. Delete `~/.android/` directory (Android Studio cache)
3. Restart Android Studio
4. Let it re-download everything

## Verification
Once sync succeeds, you should see:
- No error messages in the "Build" panel
- Green "Run" button in the toolbar
- Project structure visible in the left panel
