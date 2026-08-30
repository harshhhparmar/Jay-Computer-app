const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/ServiceDetailsScreen.kt', 'utf8');
content = content.replace('import androidx.compose.material.icons.filled.ArrowBack', 'import androidx.compose.material.icons.automirrored.filled.ArrowBack');
content = content.replace('import androidx.compose.material.icons.filled.Message', 'import androidx.compose.material.icons.automirrored.filled.Message');
fs.writeFileSync('app/src/main/java/com/example/ServiceDetailsScreen.kt', content);
