const fs = require('fs');

let content = fs.readFileSync('app/src/main/java/com/example/AppNavigation.kt', 'utf8');

const oldNav = `        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 8.dp
            ) {
                val navItemColors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    selectedIconColor = MaterialTheme.colorScheme.onPrimaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant
                )
                
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home", fontWeight = FontWeight.Medium) },
                    selected = currentRoute == "home",
                    colors = navItemColors,
                    onClick = {
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                        navController.navigate("home") {
                            popUpTo(navController.graph.startDestinationId) { 
                                saveState = false 
                            }
                            launchSingleTop = true
                            restoreState = false
                        }
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.List, contentDescription = "Services") },
                    label = { Text("Services", fontWeight = FontWeight.Medium) },
                    selected = currentRoute == "services",
                    colors = navItemColors,
                    onClick = {
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                        navController.navigate("services") {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Email, contentDescription = "Inquiry") },
                    label = { Text("Inquiry", fontWeight = FontWeight.Medium) },
                    selected = currentRoute == "inquiry",
                    colors = navItemColors,
                    onClick = {
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                        navController.navigate("inquiry") {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Info, contentDescription = "About") },
                    label = { Text("About", fontWeight = FontWeight.Medium) },
                    selected = currentRoute == "about",
                    colors = navItemColors,
                    onClick = {
                        view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                        navController.navigate("about") {
                            popUpTo(navController.graph.startDestinationId) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }`;

const newNav = `        bottomBar = {
            androidx.compose.material3.Surface(
                color = Color.White,
                shadowElevation = 16.dp,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            ) {
                NavigationBar(
                    containerColor = Color.Transparent,
                    tonalElevation = 0.dp,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp).height(72.dp)
                ) {
                    val navItemColors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color(0xFFEDE7F6),
                        selectedIconColor = Color(0xFF5E35B1),
                        unselectedIconColor = Color(0xFF9E9E9E),
                        selectedTextColor = Color(0xFF5E35B1),
                        unselectedTextColor = Color(0xFF9E9E9E)
                    )
                    
                    NavigationBarItem(
                        icon = { Icon(if (currentRoute == "home") Icons.Filled.Home else Icons.Outlined.Home, contentDescription = "Home", modifier = Modifier.size(26.dp)) },
                        label = { Text("Home", fontWeight = FontWeight.SemiBold, fontSize = 11.sp) },
                        selected = currentRoute == "home",
                        colors = navItemColors,
                        onClick = {
                            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                            navController.navigate("home") {
                                popUpTo(navController.graph.startDestinationId) { saveState = false }
                                launchSingleTop = true
                                restoreState = false
                            }
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(if (currentRoute == "services") androidx.compose.material.icons.automirrored.filled.List else androidx.compose.material.icons.automirrored.outlined.List, contentDescription = "Services", modifier = Modifier.size(26.dp)) },
                        label = { Text("Services", fontWeight = FontWeight.SemiBold, fontSize = 11.sp) },
                        selected = currentRoute == "services",
                        colors = navItemColors,
                        onClick = {
                            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                            navController.navigate("services") {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(if (currentRoute == "inquiry") Icons.Filled.Email else Icons.Outlined.Email, contentDescription = "Inquiry", modifier = Modifier.size(26.dp)) },
                        label = { Text("Inquiry", fontWeight = FontWeight.SemiBold, fontSize = 11.sp) },
                        selected = currentRoute == "inquiry",
                        colors = navItemColors,
                        onClick = {
                            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                            navController.navigate("inquiry") {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                    NavigationBarItem(
                        icon = { Icon(if (currentRoute == "about") Icons.Filled.Info else Icons.Outlined.Info, contentDescription = "About", modifier = Modifier.size(26.dp)) },
                        label = { Text("About", fontWeight = FontWeight.SemiBold, fontSize = 11.sp) },
                        selected = currentRoute == "about",
                        colors = navItemColors,
                        onClick = {
                            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                            navController.navigate("about") {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }`;

content = content.replace("import androidx.compose.material.icons.filled.*", "import androidx.compose.material.icons.filled.*\nimport androidx.compose.material.icons.outlined.*");

content = content.replace(oldNav, newNav);

fs.writeFileSync('app/src/main/java/com/example/AppNavigation.kt', content);
console.log("Rewrote AppNavigation.kt");
