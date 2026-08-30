const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/HomeScreens.kt', 'utf8');

content = content.replace(
    /contentPadding = PaddingValues\\(horizontal = 20\\.dp, vertical = 12\\.dp\\),\\s*modifier = Modifier\\.bounceClick \\{ navController\\.navigate\\("services"\\) \\}/g,
    'contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp)'
);

fs.writeFileSync('app/src/main/java/com/example/HomeScreens.kt', content);
