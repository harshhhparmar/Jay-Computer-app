const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/AppNavigation.kt', 'utf8');

content = content.replace(
    'androidx.compose.material.icons.automirrored.filled.List',
    'Icons.AutoMirrored.Filled.List'
).replace(
    'androidx.compose.material.icons.automirrored.outlined.List',
    'Icons.AutoMirrored.Outlined.List'
);

fs.writeFileSync('app/src/main/java/com/example/AppNavigation.kt', content);
console.log("Fixed AppNavigation.kt");
