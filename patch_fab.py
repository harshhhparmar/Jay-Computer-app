import re

with open("app/src/main/java/com/example/AppNavigation.kt", "r") as f:
    content = f.read()

# Add context
content = content.replace("    val view = LocalView.current", "    val view = LocalView.current\n    val context = LocalContext.current")

# Add floatingActionButton to Scaffold
fab_code = """        floatingActionButton = {
            if (currentRoute == "home") {
                FloatingActionButton(
                    onClick = { openDialer(context) },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(bottom = 80.dp) // Adjust for custom bottom bar
                ) {
                    Icon(Icons.Filled.Call, contentDescription = "Call Support")
                }
            }
        },"""

content = content.replace("        bottomBar = {", fab_code + "\n        bottomBar = {")

with open("app/src/main/java/com/example/AppNavigation.kt", "w") as f:
    f.write(content)
