const fs = require('fs');

let services = fs.readFileSync('app/src/main/java/com/example/ServicesScreens.kt', 'utf8');
services = services.replace(/GridCells\.Fixed\(2\)/g, 'GridCells.Adaptive(minSize = 160.dp)');
fs.writeFileSync('app/src/main/java/com/example/ServicesScreens.kt', services);

let home = fs.readFileSync('app/src/main/java/com/example/HomeScreens.kt', 'utf8');
home = home.replace(/GridCells\.Fixed\(2\)/g, 'GridCells.Adaptive(minSize = 160.dp)');
fs.writeFileSync('app/src/main/java/com/example/HomeScreens.kt', home);
console.log("Fixed grid for responsiveness.");
