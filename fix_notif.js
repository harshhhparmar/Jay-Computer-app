const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/HomeScreens.kt', 'utf8');

content = content.replace(
    'IconButton(onClick = { /* TODO */ }) {',
    'IconButton(onClick = { android.widget.Toast.makeText(context, "No new notifications", android.widget.Toast.LENGTH_SHORT).show() }) {'
);

fs.writeFileSync('app/src/main/java/com/example/HomeScreens.kt', content);
