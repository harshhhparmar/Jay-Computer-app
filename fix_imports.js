const fs = require('fs');

function addImport(path) {
    let content = fs.readFileSync(path, 'utf8');
    if (!content.includes('import androidx.compose.material.icons.automirrored.filled.*')) {
        content = content.replace('import androidx.compose.material.icons.filled.*', 'import androidx.compose.material.icons.filled.*\nimport androidx.compose.material.icons.automirrored.filled.*');
    }
    // Also ServicesData.kt might not have the wildcard import.
    if (path.includes('ServicesData.kt')) {
        content = content.replace('import androidx.compose.material.icons.Icons', 'import androidx.compose.material.icons.Icons\nimport androidx.compose.material.icons.automirrored.filled.*');
    }
    fs.writeFileSync(path, content);
}

addImport('app/src/main/java/com/example/MoreScreens.kt');
addImport('app/src/main/java/com/example/ServiceDetailsScreen.kt');
addImport('app/src/main/java/com/example/ServicesData.kt');

console.log("Imports added.");
