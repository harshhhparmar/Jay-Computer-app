const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/AppNavigation.kt', 'utf8');

const target = `.clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = androidx.compose.material.ripple.rememberRipple(color = activeColor)
            ) { onClick() }`;
            
const replacement = `.clickable(onClick = onClick)`;

content = content.replace(target, replacement);
fs.writeFileSync('app/src/main/java/com/example/AppNavigation.kt', content);
console.log("Fixed ripple");
