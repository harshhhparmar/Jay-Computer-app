const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/HomeScreens.kt', 'utf8');

const target = `import androidx.compose.ui.Alignment`;
const replacement = `import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import com.example.R`;

content = content.replace(target, replacement);
fs.writeFileSync('app/src/main/java/com/example/HomeScreens.kt', content);
console.log("Patched imports");
