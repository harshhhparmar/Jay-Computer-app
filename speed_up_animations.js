const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/AppNavigation.kt', 'utf8');

// Speed up NavHost transitions
content = content.replace(/spring\(stiffness = Spring\.StiffnessLow\)/g, 'tween(220)');

// Speed up CustomBottomNavItem scale/alpha/color transitions
content = content.replace(/animationSpec = spring\(stiffness = Spring\.StiffnessMediumLow\)/g, 'animationSpec = tween(150)');
content = content.replace(/animationSpec = tween\(300\)/g, 'animationSpec = tween(150)');

fs.writeFileSync('app/src/main/java/com/example/AppNavigation.kt', content);
console.log("Sped up animations");
