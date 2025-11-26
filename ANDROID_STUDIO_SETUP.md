# Android Studio Setup Instructions - IMPORTANT

## Critical Issue: Gradle Version Mismatch

If you're seeing errors about `module()` method or corrupted metadata files mentioning `9.0-milestone-1`, Android Studio is using the WRONG Gradle version.

## Step 1: Clean ALL Gradle Caches (REQUIRED)

### PowerShell Commands:
```powershell
# Clean global Gradle cache (this removes the corrupted 9.0-milestone-1 cache)
Remove-Item -Path "$env:USERPROFILE\.gradle\caches" -Recurse -Force -ErrorAction SilentlyContinue
Remove-Item -Path "$env:USERPROFILE\.gradle\daemon" -Recurse -Force -ErrorAction SilentlyContinue
Remove-Item -Path "$env:USERPROFILE\.gradle\wrapper" -Recurse -Force -ErrorAction SilentlyContinue

# Navigate to project directory and clean project caches
cd path\to\sampleRoomCache
Remove-Item -Path .\.gradle -Recurse -Force -ErrorAction SilentlyContinue
Remove-Item -Path .\.idea -Recurse -Force -ErrorAction SilentlyContinue
Remove-Item -Path .\build -Recurse -Force -ErrorAction SilentlyContinue
Remove-Item -Path .\app\build -Recurse -Force -ErrorAction SilentlyContinue
Remove-Item -Path .\local.properties -Force -ErrorAction SilentlyContinue
```

## Step 2: Fix Android Studio Gradle Settings (CRITICAL)

1. **Open Android Studio**
2. Go to **File → Settings** (or **Ctrl+Alt+S**)
3. Navigate to **Build, Execution, Deployment → Build Tools → Gradle**
4. **IMPORTANT:** Under "Gradle" section, select:
   - ☑️ **"Use Gradle from: 'gradle-wrapper.properties' file"**
   - This prevents Android Studio from using the wrong Gradle version
5. Under "Gradle JDK", select **Java 17** or **Java 11** (not Java 21 if you have it)
6. Click **OK**

## Step 3: Invalidate Caches
1. Go to **File → Invalidate Caches / Restart**
2. Select **"Invalidate and Restart"**

## Step 4: Open Project Fresh
1. After Android Studio restarts, open the project
2. Wait for sync to complete (may take 5-10 minutes first time)
3. Android Studio will download Gradle 8.2.1 automatically

## Why This Happens:

- This project requires **Gradle 8.2.1** (specified in `gradle/wrapper/gradle-wrapper.properties`)
- Android Studio was configured to use **Gradle 9.0-milestone-1** (unstable preview version)
- The `module()` API was removed, causing the error
- The corrupted metadata is from the wrong Gradle version being cached

## Verification:

After sync completes, check:
1. No error messages in "Build" panel
2. Green "Run" button appears
3. In **View → Tool Windows → Build**, you should see "BUILD SUCCESSFUL"

## If Still Failing:

### Check Gradle Version:
1. Click on "Gradle" tab (usually on right side)
2. Click refresh icon
3. Look for what Gradle version it's trying to use
4. Should say "Gradle 8.2.1"

### Nuclear Option:
```powershell
# Delete EVERYTHING Gradle-related
Remove-Item "$env:USERPROFILE\.gradle" -Recurse -Force
Remove-Item "$env:USERPROFILE\.android\build-cache" -Recurse -Force

# Restart computer (to ensure no locked files)
# Then open Android Studio and the project
```

## Expected Versions:
- ✅ Gradle: 8.2.1
- ✅ Android Gradle Plugin: 8.0.2
- ✅ Kotlin: 1.8.0
- ✅ Compose Compiler: 1.4.0
- ✅ JDK: 11 or 17

## Common Issues

### "Plugin not found" errors
- Make sure you have internet connection
- Android Studio needs to download plugins from Google's Maven repository

### "SDK not found" errors
- Go to **File → Settings → Appearance & Behavior → System Settings → Android SDK**
- Install Android SDK Platform 33
- Install Android SDK Build Tools

## Still Having Issues?

Check the "Build" output window for the EXACT error message and make sure:
1. You're using Gradle from wrapper properties (Step 2 above)
2. All caches are cleared
3. Using Java 11 or 17 (not 21)

