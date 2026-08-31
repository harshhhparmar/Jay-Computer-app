package com.example

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.HapticFeedbackConstants
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.automirrored.filled.*
import androidx.compose.material.icons.automirrored.outlined.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale

import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

const val PHONE_NUMBER = "+919925658113"
const val WHATSAPP_NUMBER = "919925658113"
const val ADDRESS_URL = "geo:0,0?q=Bus Station Road, Halvad 363330"


@OptIn(ExperimentalSharedTransitionApi::class)
val LocalSharedTransitionScope = compositionLocalOf<SharedTransitionScope?> { null }
val LocalAnimatedVisibilityScope = compositionLocalOf<AnimatedVisibilityScope?> { null }

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "home"
    val view = LocalView.current

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
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
                                    popUpTo(navController.graph.startDestinationId) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
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
        }
    ) { innerPadding ->
        SharedTransitionLayout {
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = modifier.padding(innerPadding),
            enterTransition = {
                if (targetState.destination.route?.startsWith("service_details") == true) {
                    fadeIn(tween(220)) + slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(220))
                } else {
                    EnterTransition.None
                }
            },
            exitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None },
            popExitTransition = {
                if (initialState.destination.route?.startsWith("service_details") == true) {
                    fadeOut(tween(220)) + slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(220))
                } else {
                    ExitTransition.None
                }
            }
            ) {
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
    }
}

// Helpers
fun openWhatsApp(context: Context, message: String = "") {
    try {
        val uri = Uri.parse("https://wa.me/$WHATSAPP_NUMBER?text=${Uri.encode(message)}")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context.startActivity(intent)
    } catch (e: Exception) {
        Toast.makeText(context, "WhatsApp not installed", Toast.LENGTH_SHORT).show()
    }
}

fun openDialer(context: Context) {
    val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$PHONE_NUMBER"))
    context.startActivity(intent)
}

fun openMaps(context: Context) {
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ADDRESS_URL))
    context.startActivity(intent)
}

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
        animationSpec = tween(150),
        label = "scale"
    )
    val color by animateColorAsState(
        targetValue = if (selected) activeColor else inactiveColor,
        animationSpec = tween(150),
        label = "color"
    )
    val indicatorAlpha by animateFloatAsState(
        targetValue = if (selected) 1f else 0f,
        animationSpec = tween(150),
        label = "alpha"
    )

    Box(
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick)
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
                                cornerRadius = androidx.compose.ui.geometry.CornerRadius(size.height / 2f, size.height / 2f)
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
