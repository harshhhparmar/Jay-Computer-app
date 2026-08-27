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
        }
    ) { innerPadding ->
        SharedTransitionLayout {
            NavHost(
                navController = navController,
                startDestination = "home",
                modifier = modifier.padding(innerPadding),
            enterTransition = { fadeIn(tween(300)) + slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(300)) },
            exitTransition = { fadeOut(tween(300)) },
            popEnterTransition = { fadeIn(tween(300)) },
            popExitTransition = { fadeOut(tween(300)) + slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(300)) }
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
