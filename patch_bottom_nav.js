const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/AppNavigation.kt', 'utf8');

// 1. Add imports
const newImports = `
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
`;

content = content.replace('import androidx.compose.ui.unit.sp', 'import androidx.compose.ui.unit.sp' + newImports);

// 2. Replace bottomBar
const bottomBarTarget = `        bottomBar = {
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
                        icon = { Icon(if (currentRoute == "services") Icons.AutoMirrored.Filled.List else Icons.AutoMirrored.Outlined.List, contentDescription = "Services", modifier = Modifier.size(26.dp)) },
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

const bottomBarReplacement = `        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                androidx.compose.material3.Surface(
                    color = Color(0xFFFBF9FF),
                    shadowElevation = 12.dp,
                    shape = RoundedCornerShape(24.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        CustomBottomNavItem(
                            icon = if (currentRoute == "home") Icons.Filled.Home else Icons.Outlined.Home,
                            label = "Home",
                            selected = currentRoute == "home",
                            onClick = {
                                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                                navController.navigate("home") {
                                    popUpTo(navController.graph.startDestinationId) { saveState = false }
                                    launchSingleTop = true
                                    restoreState = false
                                }
                            }
                        )
                        CustomBottomNavItem(
                            icon = if (currentRoute == "services") Icons.AutoMirrored.Filled.List else Icons.AutoMirrored.Outlined.List,
                            label = "Services",
                            selected = currentRoute == "services",
                            onClick = {
                                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                                navController.navigate("services") {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                        CustomBottomNavItem(
                            icon = if (currentRoute == "inquiry") Icons.Filled.Email else Icons.Outlined.Email,
                            label = "Inquiry",
                            selected = currentRoute == "inquiry",
                            onClick = {
                                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                                navController.navigate("inquiry") {
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            }
                        )
                        CustomBottomNavItem(
                            icon = if (currentRoute == "about") Icons.Filled.Info else Icons.Outlined.Info,
                            label = "About",
                            selected = currentRoute == "about",
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
            }
        }`;

content = content.replace(bottomBarTarget, bottomBarReplacement);

// 3. Append CustomBottomNavItem
const newComponent = `
@Composable
fun RowScope.CustomBottomNavItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val activeColor = Color(0xFF5E35B1)
    val inactiveColor = Color(0xFF9E9E9E)
    val indicatorColor = Color(0xFFEDE7F6)

    val scale by animateFloatAsState(
        targetValue = if (selected) 1.15f else 1.0f,
        animationSpec = spring(stiffness = Spring.StiffnessMediumLow),
        label = "scale"
    )
    val color by animateColorAsState(
        targetValue = if (selected) activeColor else inactiveColor,
        animationSpec = tween(300),
        label = "color"
    )
    val indicatorAlpha by animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = tween(300),
        label = "alpha"
    )

    Box(
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(16.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = androidx.compose.material.ripple.rememberRipple(color = activeColor)
            ) { onClick() }
            .padding(vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp)
                    .drawBehind {
                        if (indicatorAlpha > 0f) {
                            drawRoundRect(
                                color = indicatorColor.copy(alpha = indicatorAlpha),
                                cornerRadius = androidx.compose.ui.geometry.CornerRadius(32f, 32f)
                            )
                        }
                    }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = color,
                    modifier = Modifier
                        .size(24.dp)
                        .scale(scale)
                )
            }
            Text(
                text = label,
                fontSize = 11.sp,
                fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
                color = color,
                maxLines = 1
            )
        }
    }
}
`;

content = content + newComponent;
fs.writeFileSync('app/src/main/java/com/example/AppNavigation.kt', content);
console.log("Patched AppNavigation.kt");
