const fs = require('fs');
let code = fs.readFileSync('app/src/main/java/com/example/AppNavigation.kt', 'utf8');

// add imports
const imports = `import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
`;

code = code.replace("import androidx.compose.animation.AnimatedContentTransitionScope", imports + "import androidx.compose.animation.AnimatedContentTransitionScope");

const locals = `
@OptIn(ExperimentalSharedTransitionApi::class)
val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope?> { null }
val LocalAnimatedVisibilityScope = compositionLocalOf<AnimatedVisibilityScope?> { null }

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {`;

code = code.replace("@Composable\nfun AppNavigation(modifier: Modifier = Modifier) {", locals);

const navHostStart = `        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = modifier.padding(innerPadding),`;

const sharedLayoutWrapper = `        SharedTransitionLayout {
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = modifier.padding(innerPadding),`;

code = code.replace(navHostStart, sharedLayoutWrapper);

const composablesToReplace = `        ) {
            composable("home") { HomeScreen(navController) }
            composable("services") { ServicesScreen(navController) }
            composable(
                "service_details/{id}",
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                val service = ServicesData.services.find { it.id == id }
                if (service != null) {
                    ServiceDetailsScreen(navController, service)
                }
            }
            composable("inquiry") { InquiryScreen() }
            composable("about") { AboutScreen() }
        }
    }`;

const replacedComposables = `            ) {
                composable("home") { 
                    CompositionLocalProvider(
                        LocalSharedTransitionScope provides this@SharedTransitionLayout,
                        LocalAnimatedVisibilityScope provides this@composable
                    ) {
                        HomeScreen(navController) 
                    }
                }
                composable("services") { 
                    CompositionLocalProvider(
                        LocalSharedTransitionScope provides this@SharedTransitionLayout,
                        LocalAnimatedVisibilityScope provides this@composable
                    ) {
                        ServicesScreen(navController) 
                    }
                }
                composable(
                    "service_details/{id}",
                    arguments = listOf(navArgument("id") { type = NavType.StringType })
                ) { backStackEntry ->
                    val id = backStackEntry.arguments?.getString("id")
                    val service = ServicesData.services.find { it.id == id }
                    if (service != null) {
                        CompositionLocalProvider(
                            LocalSharedTransitionScope provides this@SharedTransitionLayout,
                            LocalAnimatedVisibilityScope provides this@composable
                        ) {
                            ServiceDetailsScreen(navController, service)
                        }
                    }
                }
                composable("inquiry") { InquiryScreen() }
                composable("about") { AboutScreen() }
            }
        }
    }`;

code = code.replace(composablesToReplace, replacedComposables);

fs.writeFileSync('app/src/main/java/com/example/AppNavigation.kt', code);
console.log("AppNavigation updated!");
