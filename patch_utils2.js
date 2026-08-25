const fs = require('fs');
let code = fs.readFileSync('app/src/main/java/com/example/Utils.kt', 'utf8');

// Remove the inline imports
code = code.replace("\\nimport androidx.compose.animation.ExperimentalSharedTransitionApi\\nimport androidx.compose.animation.SharedTransitionScope\\nimport androidx.compose.animation.AnimatedVisibilityScope\\nimport androidx.compose.ui.Modifier\\nimport androidx.compose.ui.composed\\n", "");

// Add to top
const topImports = `
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.AnimatedVisibilityScope
`;

code = code.replace("import android.view.HapticFeedbackConstants", topImports + "import android.view.HapticFeedbackConstants");

fs.writeFileSync('app/src/main/java/com/example/Utils.kt', code);
