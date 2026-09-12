import re

with open("app/src/main/java/com/example/ServicesScreens.kt", "r") as f:
    content = f.read()

replacement = """
                if (hasError && !isLoading) {
                    ErrorStateComponent(
                        modifier = Modifier.weight(1f),
                        onRetry = {
                            hasError = false
                            isLoading = true
                        }
                    )
                } else if (!isLoading && filteredServices.isEmpty()) {
                    Box(modifier = Modifier.weight(1f).fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Filled.Search, contentDescription = null, modifier = Modifier.size(64.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f))
                            Spacer(modifier = Modifier.height(16.dp))
                            Text("No services found", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            Text("Try adjusting your search or category filter.", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.7f))
                        }
                    }
                } else {
"""

content = content.replace("""                if (hasError && !isLoading) {
                    ErrorStateComponent(
                        modifier = Modifier.weight(1f),
                        onRetry = {
                            hasError = false
                            isLoading = true
                        }
                    )
                } else {""", replacement)

with open("app/src/main/java/com/example/ServicesScreens.kt", "w") as f:
    f.write(content)
