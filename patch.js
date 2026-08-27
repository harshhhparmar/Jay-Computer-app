const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/ServicesScreens.kt', 'utf8');

const importSearch = "import androidx.compose.foundation.lazy.grid.LazyVerticalGrid";
if (!content.includes("import androidx.compose.foundation.lazy.LazyRow")) {
    content = content.replace(importSearch, importSearch + "\nimport androidx.compose.foundation.lazy.LazyRow\nimport androidx.compose.foundation.lazy.items");
}

const stateSearch = 'var searchQuery by remember { mutableStateOf("") }';
const stateReplace = 'var searchQuery by remember { mutableStateOf("") }\n    var selectedCategory by remember { mutableStateOf("All") }';
content = content.replace(stateSearch, stateReplace);

const filterBlockSearch = `            val filteredServices = ServicesData.services.filter { 
                it.titleEn.contains(searchQuery, ignoreCase = true) || 
                it.titleGu.contains(searchQuery, ignoreCase = true) 
            }`;

const filterBlockReplace = `            val categories = remember { listOf("All") + ServicesData.services.map { it.categoryEn }.distinct() }
            
            LazyRow(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(categories) { category ->
                    FilterChip(
                        selected = selectedCategory == category,
                        onClick = { selectedCategory = category },
                        label = { Text(category) },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                            selectedLabelColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    )
                }
            }
            
            val filteredServices = ServicesData.services.filter { 
                val matchesSearch = it.titleEn.contains(searchQuery, ignoreCase = true) || 
                                    it.titleGu.contains(searchQuery, ignoreCase = true)
                val matchesCategory = selectedCategory == "All" || it.categoryEn == selectedCategory
                matchesSearch && matchesCategory
            }`;

content = content.replace(filterBlockSearch, filterBlockReplace);

fs.writeFileSync('app/src/main/java/com/example/ServicesScreens.kt', content);
console.log("Patched");
