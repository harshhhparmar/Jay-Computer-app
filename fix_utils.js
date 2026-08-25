const fs = require('fs');
let code = fs.readFileSync('app/src/main/java/com/example/Utils.kt', 'utf8');

const regex = /\\nimport androidx\.compose\.animation\.ExperimentalSharedTransitionApi.*import androidx\.compose\.ui\.composed/s;
code = code.replace(regex, "");
code = code.replace(/\\n/g, ""); // strip literal \n if any exist

fs.writeFileSync('app/src/main/java/com/example/Utils.kt', code);
console.log("Utils cleaned");
