const fs = require('fs');
let code = fs.readFileSync('app/src/main/java/com/example/ServicesScreens.kt', 'utf8');

const targetBoxGrid = `            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {`;

const newBoxGrid = `            Box(
                modifier = Modifier
                    .size(48.dp)
                    .sharedElementModifier("icon_\${service.id}")
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {`;

code = code.replace(targetBoxGrid, newBoxGrid);

const targetBoxDetails = `            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {`;

const newBoxDetails = `            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .sharedElementModifier("icon_\${service.id}")
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {`;

code = code.replace(targetBoxDetails, newBoxDetails);

fs.writeFileSync('app/src/main/java/com/example/ServicesScreens.kt', code);
console.log("ServicesScreens updated!");
