import sys

def remove_animated_visibility(path):
    with open(path, "r") as f:
        content = f.read()

    # In ServicesScreens.kt:
    # 1. 
    target1 = """                AnimatedVisibility(
                    visible = visible,
                    enter = fadeIn(tween(100)) + slideInVertically(tween(100), initialOffsetY = { -20 })
                ) {
                    Column {"""
    replacement1 = """                Column {"""
    
    # 2.
    target2 = """                                AnimatedVisibility(
                                    visible = visible,
                                    enter = fadeIn(tween(100)) + slideInVertically(tween(100), initialOffsetY = { 30 })
                                ) {
                                    ServiceGridItem(service) {
                                        navController.navigate("service_details/${service.id}")
                                    }
                                }"""
    replacement2 = """                                ServiceGridItem(service) {
                                    navController.navigate("service_details/${service.id}")
                                }"""
                                
    content = content.replace(target1, replacement1)
    content = content.replace(target2, replacement2)
    
    # Also remove `} // end AnimatedVisibility` if it exists. Wait, my replacement1 removes the `) {` but leaves a trailing `}`.
    # Ah, let's do this more cleanly.
