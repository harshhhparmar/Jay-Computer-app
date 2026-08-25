const fs = require('fs');
let code = fs.readFileSync('app/src/main/java/com/example/HomeScreens.kt', 'utf8');

const newHeroCard = `
@Composable
fun HeroCard(context: android.content.Context, navController: NavController) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF673AB7)),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF673AB7), // Deep Purple
                            Color(0xFF3F51B5)  // Indigo
                        )
                    )
                )
                .padding(24.dp)
        ) {
            Column {
                Text(
                    text = "Welcome to Jay Computer",
                    style = MaterialTheme.typography.labelMedium,
                    color = Color.White.copy(alpha = 0.8f)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "All Government Services, Under One Roof",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    lineHeight = 28.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Fast, secure, and hassle-free document processing.",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.9f)
                )
                Spacer(modifier = Modifier.height(24.dp))
                
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    HeroQuickAction(Icons.Default.Phone, "Call") { openDialer(context) }
                    HeroQuickAction(Icons.Default.Message, "WhatsApp") { openWhatsApp(context, "Hello Jay Computer!") }
                    HeroQuickAction(Icons.Default.LocationOn, "Location") { openMaps(context) }
                    HeroQuickAction(Icons.Default.List, "Services") { navController.navigate("services") }
                }
            }
        }
    }
}

@Composable
fun HeroQuickAction(icon: ImageVector, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.bounceClick { onClick() }
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(Color.White.copy(alpha = 0.2f)),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = label, tint = Color.White, modifier = Modifier.size(24.dp))
        }
        Spacer(modifier = Modifier.height(6.dp))
        Text(label, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Color.White)
    }
}
`;

// Replace the Hero and Quick Actions with a single HeroCard call
const sectionToReplace = `                    // Premium Hero Card
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    Brush.linearGradient(
                                        colors = listOf(
                                            MaterialTheme.colorScheme.primary,
                                            MaterialTheme.colorScheme.tertiary
                                        )
                                    )
                                )
                                .padding(24.dp)
                        ) {
                            Column(horizontalAlignment = Alignment.Start) {
                                Text(
                                    text = "Welcome to Jay Computer",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "All Government Services, Under One Roof",
                                    style = MaterialTheme.typography.titleLarge,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.onPrimary,
                                    lineHeight = 28.sp
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Fast, secure, and hassle-free document processing.",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.9f)
                                )
                                Spacer(modifier = Modifier.height(20.dp))
                                Button(
                                    onClick = { navController.navigate("services") },
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.onPrimary,
                                        contentColor = MaterialTheme.colorScheme.primary
                                    ),
                                    shape = RoundedCornerShape(12.dp),
                                    contentPadding = PaddingValues(horizontal = 24.dp, vertical = 12.dp)
                                ) {
                                    Text("Explore Services", fontWeight = FontWeight.Bold)
                                }
                            }
                        }
                    }
                }
            }

            item {
                ScrollEnterAnimation {
                    // Quick Actions
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        QuickActionItem(Icons.Default.Phone, "Call", MaterialTheme.colorScheme.secondaryContainer) { openDialer(context) }
                        QuickActionItem(Icons.Default.Message, "WhatsApp", Color(0xFFE8F5E9)) { openWhatsApp(context, "Hello Jay Computer!") }
                        QuickActionItem(Icons.Default.LocationOn, "Location", MaterialTheme.colorScheme.tertiaryContainer) { openMaps(context) }
                        QuickActionItem(Icons.Default.List, "Services", MaterialTheme.colorScheme.primaryContainer) { navController.navigate("services") }
                    }`;

const replacement = `                    // Premium Hero Card
                    HeroCard(context = context, navController = navController)`;

if (code.includes(sectionToReplace)) {
    code = code.replace(sectionToReplace, replacement);
    
    // Append the new components to the end
    code += "\\n" + newHeroCard + "\\n";
    fs.writeFileSync('app/src/main/java/com/example/HomeScreens.kt', code);
    console.log("Success");
} else {
    console.log("Could not find section to replace.");
}
