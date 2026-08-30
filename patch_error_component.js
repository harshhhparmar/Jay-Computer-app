const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/ui/ErrorStateComponent.kt', 'utf8');

content = content.replace('mainAxisAlignment = MainAxisAlignment.Center', 'verticalArrangement = Arrangement.Center');

fs.writeFileSync('app/src/main/java/com/example/ui/ErrorStateComponent.kt', content);
console.log("Patched ErrorStateComponent.kt");
