const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/HomeScreens.kt', 'utf8');

const target = `                            Box(
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .background(MaterialTheme.colorScheme.primary),
                                contentAlignment = Alignment.Center
                            ) {
                                Text("J", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                            }`;

const replacement = `                            Image(
                                painter = painterResource(id = R.drawable.jay_logo),
                                contentDescription = "Jay Computer Logo",
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(RoundedCornerShape(8.dp)),
                                contentScale = ContentScale.Crop
                            )`;

content = content.replace(target, replacement);
fs.writeFileSync('app/src/main/java/com/example/HomeScreens.kt', content);
console.log("Patched HomeScreens.kt");
