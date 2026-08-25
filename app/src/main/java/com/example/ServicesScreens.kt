package com.example

import android.view.HapticFeedbackConstants
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.lazy.grid.items
import kotlinx.coroutines.delay
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.draw.shadow
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicesScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    var isLoading by rememberSaveable { mutableStateOf(true) }
    
    LaunchedEffect(Unit) {
        if (isLoading) {
            delay(400) // Simulate data loading
            isLoading = false
        }
    }

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val isScrolled = scrollBehavior.state.overlappedFraction > 0.01f
    val elevation by animateDpAsState(
        targetValue = if (isScrolled) 4.dp else 0.dp,
        label = "TopAppBarElevation"
    )
    
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(elevation),
                title = { Text("All Services", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize()) {
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                placeholder = { Text("Search services...") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search") },
                singleLine = true,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = MaterialTheme.colorScheme.surface,
                    unfocusedContainerColor = MaterialTheme.colorScheme.surface,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            
            val filteredServices = ServicesData.services.filter { 
                it.titleEn.contains(searchQuery, ignoreCase = true) || 
                it.titleGu.contains(searchQuery, ignoreCase = true) 
            }
            
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (isLoading) {
                    items(8) {
                        ShimmerServiceGridItem()
                    }
                } else {
                    items(filteredServices) { service ->
                        ScrollEnterAnimation {
                            ServiceGridItem(service) {
                                navController.navigate("service_details/${service.id}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ShimmerServiceGridItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .height(14.dp)
                    .fillMaxWidth(0.9f)
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
                    .shimmerEffect()
            )
            Spacer(modifier = Modifier.height(6.dp))
            Box(
                modifier = Modifier
                    .height(14.dp)
                    .fillMaxWidth(0.6f)
                    .clip(androidx.compose.foundation.shape.RoundedCornerShape(4.dp))
                    .shimmerEffect()
            )
        }
    }
}

@Composable
fun ServiceGridItem(service: Service, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .bounceClick { onClick() }
            .height(140.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    getIconForName(service.iconName),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.size(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = service.titleEn,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
            if (service.popular) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Popular",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceDetailsScreen(navController: NavController, service: Service) {
    val context = LocalContext.current
    val view = LocalView.current
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val isScrolled = scrollBehavior.state.overlappedFraction > 0.01f
    val elevation by animateDpAsState(
        targetValue = if (isScrolled) 4.dp else 0.dp,
        label = "TopAppBarElevation"
    )

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(elevation),
                title = { Text("Service Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    scrolledContainerColor = MaterialTheme.colorScheme.primary
                ),
                scrollBehavior = scrollBehavior
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primaryContainer),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        getIconForName(service.iconName),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.size(32.dp)
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(service.titleEn, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold)
                    Text(service.categoryEn, style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.primary)
                }
            }
            
            HorizontalDivider()
            
            Text("Description", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
            Text(service.descriptionEn, style = MaterialTheme.typography.bodyMedium)
            Text(service.descriptionGu, color = MaterialTheme.colorScheme.onSurfaceVariant, style = MaterialTheme.typography.bodyMedium)
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text("Required Documents", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleMedium)
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    service.documentsEn.forEachIndexed { index, doc ->
                        Row(verticalAlignment = Alignment.Top) {
                            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(20.dp).padding(top = 2.dp))
                            Spacer(modifier = Modifier.width(8.dp))
                            Column {
                                Text(doc, style = MaterialTheme.typography.bodyMedium, fontWeight = FontWeight.Medium)
                                Text(service.documentsGu[index], style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    }
                }
            }
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Button(
                onClick = {
                    view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                    val message = "Hello Jay Computer, I want to enquire about ${service.titleEn}."
                    openWhatsApp(context, message)
                },
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
            ) {
                Icon(Icons.Default.Message, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Enquire on WhatsApp", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
    }
}
