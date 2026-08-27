const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/AppNavigation.kt', 'utf8');

if (!content.includes('import androidx.compose.material.icons.automirrored.filled.*')) {
    content = content.replace(
        'import androidx.compose.material.icons.filled.*',
        'import androidx.compose.material.icons.filled.*\nimport androidx.compose.material.icons.automirrored.filled.*\nimport androidx.compose.material.icons.automirrored.outlined.*'
    );
}

fs.writeFileSync('app/src/main/java/com/example/AppNavigation.kt', content);
console.log("Fixed AppNavigation.kt imports");
