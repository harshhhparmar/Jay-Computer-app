const fs = require('fs');

// 1. Update ServicesScreens.kt
let content = fs.readFileSync('app/src/main/java/com/example/ServicesScreens.kt', 'utf8');

// Add imports
content = content.replace('import androidx.compose.ui.input.nestedscroll.nestedScroll', 'import androidx.compose.ui.input.nestedscroll.nestedScroll\nimport com.example.ui.ErrorStateComponent');

// Modify states
const targetState = `    var isLoading by rememberSaveable { mutableStateOf(true) }
    var visible by remember { mutableStateOf(false) }
    
    val view = LocalView.current

    LaunchedEffect(Unit) {
        if (isLoading) {
            delay(300) // Simulate data loading
            isLoading = false
        }
        visible = true
    }`;

const replacementState = `    var isLoading by rememberSaveable { mutableStateOf(true) }
    var hasError by rememberSaveable { mutableStateOf(true) }
    var visible by remember { mutableStateOf(false) }
    
    val view = LocalView.current

    LaunchedEffect(isLoading) {
        if (isLoading) {
            visible = false
            delay(800) // Simulate network delay
            isLoading = false
            if (!hasError) {
                visible = true
            }
        }
    }`;

content = content.replace(targetState, replacementState);

// Replace the LazyVerticalGrid block to include error state
const targetGrid = `                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    if (isLoading) {
                        items(8) {
                            ShimmerServiceGridItem()
                        }
                    } else {
                        itemsIndexed(filteredServices) { index, service ->
                            AnimatedVisibility(
                                visible = visible,
                                enter = fadeIn(tween(400, delayMillis = 100 + (index * 30))) + slideInVertically(tween(400, delayMillis = 100 + (index * 30)), initialOffsetY = { 30 })
                            ) {
                                ServiceGridItem(service) {
                                    navController.navigate("service_details/\${service.id}")
                                }
                            }
                        }
                    }
                }`;

const replacementGrid = `                if (hasError && !isLoading) {
                    ErrorStateComponent(
                        modifier = Modifier.weight(1f),
                        onRetry = {
                            hasError = false
                            isLoading = true
                        }
                    )
                } else {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        contentPadding = PaddingValues(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        if (isLoading) {
                            items(8) {
                                ShimmerServiceGridItem()
                            }
                        } else {
                            itemsIndexed(filteredServices) { index, service ->
                                AnimatedVisibility(
                                    visible = visible,
                                    enter = fadeIn(tween(400, delayMillis = 100 + (index * 30))) + slideInVertically(tween(400, delayMillis = 100 + (index * 30)), initialOffsetY = { 30 })
                                ) {
                                    ServiceGridItem(service) {
                                        navController.navigate("service_details/\${service.id}")
                                    }
                                }
                            }
                        }
                    }
                }`;

content = content.replace(targetGrid, replacementGrid);
fs.writeFileSync('app/src/main/java/com/example/ServicesScreens.kt', content);

console.log("Patched error handling in ServicesScreens.kt");
