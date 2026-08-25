const fs = require('fs');
let code = fs.readFileSync('app/src/main/java/com/example/ServicesScreens.kt', 'utf8');

const target = `                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary
                ),`;

const replacement = `                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        val shareText = """
                            *Jay Computer - Service Info*
                            
                            *Service:* \${service.titleEn}
                            *Category:* \${service.categoryEn}
                            
                            *Description:*
                            \${service.descriptionEn}
                            
                            *Required Documents:*
                            \${service.documentsEn.joinToString("\\n") { "- $it" }}
                        """.trimIndent()
                        
                        val sendIntent: android.content.Intent = android.content.Intent().apply {
                            action = android.content.Intent.ACTION_SEND
                            putExtra(android.content.Intent.EXTRA_TEXT, shareText)
                            type = "text/plain"
                        }
                        val shareIntent = android.content.Intent.createChooser(sendIntent, "Share Service")
                        context.startActivity(shareIntent)
                    }) {
                        Icon(Icons.Default.Share, contentDescription = "Share")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary
                ),`;

if (code.includes(target)) {
    code = code.replace(target, replacement);
    fs.writeFileSync('app/src/main/java/com/example/ServicesScreens.kt', code);
    console.log("Success");
} else {
    console.log("Could not find target string.");
}
