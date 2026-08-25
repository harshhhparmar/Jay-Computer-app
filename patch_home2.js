const fs = require('fs');
let code = fs.readFileSync('app/src/main/java/com/example/HomeScreens.kt', 'utf8');

const targetBox = `            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)),
                contentAlignment = Alignment.Center
            ) {`;

const newBox = `            Box(
                modifier = Modifier
                    .size(48.dp)
                    .sharedElementModifier("icon_\${service.id}")
                    .clip(RoundedCornerShape(12.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.6f)),
                contentAlignment = Alignment.Center
            ) {`;

if (code.includes(targetBox)) {
    code = code.replace(targetBox, newBox);
    fs.writeFileSync('app/src/main/java/com/example/HomeScreens.kt', code);
    console.log("HomeScreens updated!");
} else {
    console.log("Target not found in HomeScreens.kt");
}
