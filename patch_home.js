const fs = require('fs');
let code = fs.readFileSync('app/src/main/java/com/example/HomeScreens.kt', 'utf8');

const newContent = `    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                modifier = Modifier.shadow(elevation),
                title = { Text("Jay Computer", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    actionIconContentColor = MaterialTheme.colorScheme.onSurface,
                    scrolledContainerColor = MaterialTheme.colorScheme.surface
                ),
                actions = {
                    IconButton(onClick = { navController.navigate("services") }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                    IconButton(onClick = { /* TODO */ }) {
                        Icon(Icons.Default.Notifications, contentDescription = "Notifications")
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            contentPadding = PaddingValues(top = 16.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item {
                ScrollEnterAnimation {
                    // Premium Hero Card
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
                    }
                }
            }

            item {
                ScrollEnterAnimation {
                    // Stats/Trust
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        CompactStatCard("100+", "Services", Modifier.weight(1f))
                        CompactStatCard("Fast", "Processing", Modifier.weight(1f))
                        CompactStatCard("Reliable", "Support", Modifier.weight(1f))
                    }
                }
            }

            item {
                ScrollEnterAnimation {
                    // Popular Services Header
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Popular Services", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                        TextButton(
                            onClick = {
                                view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                                navController.navigate("services")
                            },
                            contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("View All")
                        }
                    }
                }
            }

            val popularServices = ServicesData.services.filter { it.popular }.take(6)
            
            if (isLoading) {
                items(6) {
                    ShimmerServiceListItem()
                }
            } else {
                items(popularServices) { service ->
                    ScrollEnterAnimation {
                        PremiumServiceCard(service) {
                            navController.navigate("service_details/\\$\\{service.id\\}")
                        }
                    }
                }
            }
        }
    }`;

code = code.replace(/    Scaffold\(contentWindowInsets = WindowInsets\(0, 0, 0, 0\),[\s\S]*?    }\n    }\n/, newContent);
fs.writeFileSync('app/src/main/java/com/example/HomeScreens.kt', code);
