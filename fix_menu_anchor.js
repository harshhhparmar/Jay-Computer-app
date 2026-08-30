const fs = require('fs');

let more = fs.readFileSync('app/src/main/java/com/example/MoreScreens.kt', 'utf8');
more = more.replace('Modifier.menuAnchor().fillMaxWidth()', 'Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable).fillMaxWidth()');
// Ensure import for MenuAnchorType is there
if (!more.includes('import androidx.compose.material3.MenuAnchorType')) {
    more = more.replace('import androidx.compose.material3.*', 'import androidx.compose.material3.*\nimport androidx.compose.material3.MenuAnchorType');
}
fs.writeFileSync('app/src/main/java/com/example/MoreScreens.kt', more);

let services = fs.readFileSync('app/src/main/java/com/example/ServicesScreens.kt', 'utf8');
services = services.replace('Modifier.menuAnchor().fillMaxWidth()', 'Modifier.menuAnchor(MenuAnchorType.PrimaryNotEditable).fillMaxWidth()');
if (services.includes('menuAnchor(MenuAnchorType') && !services.includes('import androidx.compose.material3.MenuAnchorType')) {
    services = services.replace('import androidx.compose.material3.*', 'import androidx.compose.material3.*\nimport androidx.compose.material3.MenuAnchorType');
}
fs.writeFileSync('app/src/main/java/com/example/ServicesScreens.kt', services);

console.log("Fixed menuAnchor warning.");
