const fs = require('fs');

// 1. Update libs.versions.toml
let toml = fs.readFileSync('gradle/libs.versions.toml', 'utf8');
toml = toml.replace('[versions]', '[versions]\ncoreSplashscreen = "1.0.1"');
toml = toml.replace('[libraries]', '[libraries]\nandroidx-core-splashscreen = { group = "androidx.core", name = "core-splashscreen", version.ref = "coreSplashscreen" }');
fs.writeFileSync('gradle/libs.versions.toml', toml);

// 2. Update build.gradle.kts
let gradle = fs.readFileSync('app/build.gradle.kts', 'utf8');
gradle = gradle.replace('implementation(libs.androidx.core.ktx)', 'implementation(libs.androidx.core.ktx)\n  implementation(libs.androidx.core.splashscreen)');
fs.writeFileSync('app/build.gradle.kts', gradle);

// 3. Update themes.xml
const themesXml = `<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="Theme.MyApplication" parent="Theme.SplashScreen">
        <!-- Splash screen background -->
        <item name="windowSplashScreenBackground">#FFFFFF</item>
        <!-- Splash screen icon -->
        <item name="windowSplashScreenAnimatedIcon">@drawable/jay_logo</item>
        <!-- The theme to apply after the splash screen -->
        <item name="postSplashScreenTheme">@style/Theme.MyApplication.Inner</item>
    </style>
    
    <style name="Theme.MyApplication.Inner" parent="android:Theme.DeviceDefault.NoActionBar">
        <item name="android:windowBackground">@android:color/white</item>
    </style>
</resources>
`;
fs.writeFileSync('app/src/main/res/values/themes.xml', themesXml);

// 4. Update MainActivity.kt
let mainActivity = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');
mainActivity = mainActivity.replace('import androidx.compose.ui.Modifier', 'import androidx.compose.ui.Modifier\nimport androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen');
mainActivity = mainActivity.replace('super.onCreate(savedInstanceState)', 'val splashScreen = installSplashScreen()\n        super.onCreate(savedInstanceState)');
fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', mainActivity);

console.log("Patched splash screen");
