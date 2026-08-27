const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/ServicesScreens.kt', 'utf8');

const searchBarTarget = `                        OutlinedTextField(
                            value = searchQuery,
                            onValueChange = { searchQuery = it },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 8.dp),
                            placeholder = { Text("Search for a service...", color = Color.Gray) },
                            leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = MaterialTheme.colorScheme.primary) },
                            singleLine = true,
                            shape = RoundedCornerShape(16.dp),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                focusedBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                                unfocusedBorderColor = Color(0xFFE0E0E0),
                            )
                        )`;

const searchBarReplacement = `                        var expanded by remember { mutableStateOf(false) }
                        val suggestions = if (searchQuery.isNotBlank()) {
                            ServicesData.services.filter { 
                                it.titleEn.contains(searchQuery, ignoreCase = true) 
                            }.take(4)
                        } else emptyList()

                        ExposedDropdownMenuBox(
                            expanded = expanded && suggestions.isNotEmpty(),
                            onExpandedChange = { expanded = it },
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                        ) {
                            OutlinedTextField(
                                value = searchQuery,
                                onValueChange = { 
                                    searchQuery = it
                                    expanded = true
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .menuAnchor(MenuAnchorType.PrimaryEditable, true),
                                placeholder = { Text("Search for a service...", color = Color.Gray) },
                                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search", tint = MaterialTheme.colorScheme.primary) },
                                singleLine = true,
                                shape = RoundedCornerShape(16.dp),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedContainerColor = Color.White,
                                    unfocusedContainerColor = Color.White,
                                    focusedBorderColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5f),
                                    unfocusedBorderColor = Color(0xFFE0E0E0),
                                )
                            )
                            
                            ExposedDropdownMenu(
                                expanded = expanded && suggestions.isNotEmpty(),
                                onDismissRequest = { expanded = false },
                                modifier = Modifier.background(Color.White).fillMaxWidth(0.9f)
                            ) {
                                suggestions.forEach { suggestion ->
                                    DropdownMenuItem(
                                        text = { Text(suggestion.titleEn) },
                                        onClick = {
                                            searchQuery = suggestion.titleEn
                                            expanded = false
                                            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
                                        }
                                    )
                                }
                            }
                        }`;

content = content.replace(searchBarTarget, searchBarReplacement);
fs.writeFileSync('app/src/main/java/com/example/ServicesScreens.kt', content);
console.log("Rewrote ServicesScreens.kt search bar");
