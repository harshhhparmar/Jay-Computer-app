const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

const replacement = `enableEdgeToEdge()

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val display = windowManager.defaultDisplay
            val modes = display.supportedModes
            val highestMode = modes.maxByOrNull { it.refreshRate }
            if (highestMode != null) {
                val layoutParams = window.attributes
                layoutParams.preferredDisplayModeId = highestMode.modeId
                window.attributes = layoutParams
            }
        }`;

content = content.replace(/enableEdgeToEdge\(\)([\s\S]*?)setContent/g, replacement + "\n\n        setContent");
fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', content);
console.log("Patched MainActivity.kt");
