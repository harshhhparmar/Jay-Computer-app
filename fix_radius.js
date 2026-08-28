const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/AppNavigation.kt', 'utf8');

const target = `cornerRadius = androidx.compose.ui.geometry.CornerRadius(32f, 32f)`;
const replacement = `cornerRadius = androidx.compose.ui.geometry.CornerRadius(size.height / 2f, size.height / 2f)`;

content = content.replace(target, replacement);
fs.writeFileSync('app/src/main/java/com/example/AppNavigation.kt', content);
console.log("Fixed radius");
