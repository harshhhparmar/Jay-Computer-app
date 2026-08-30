const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/MainActivity.kt', 'utf8');

content = content.replace(
    'val display = windowManager.defaultDisplay',
    '@Suppress("DEPRECATION")\n            val display = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.R) display else windowManager.defaultDisplay'
);

fs.writeFileSync('app/src/main/java/com/example/MainActivity.kt', content);
