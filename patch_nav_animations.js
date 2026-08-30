const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/AppNavigation.kt', 'utf8');

const t1 = `enterTransition = { fadeIn(tween(300)) + slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, tween(300)) }`;
const r1 = `enterTransition = { fadeIn(spring(stiffness = Spring.StiffnessLow)) + slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Left, spring(stiffness = Spring.StiffnessLow)) }`;
content = content.replace(t1, r1);

const t2 = `exitTransition = { fadeOut(tween(300)) }`;
const r2 = `exitTransition = { fadeOut(spring(stiffness = Spring.StiffnessLow)) }`;
content = content.replace(t2, r2);

const t3 = `popEnterTransition = { fadeIn(tween(300)) }`;
const r3 = `popEnterTransition = { fadeIn(spring(stiffness = Spring.StiffnessLow)) }`;
content = content.replace(t3, r3);

const t4 = `popExitTransition = { fadeOut(tween(300)) + slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, tween(300)) }`;
const r4 = `popExitTransition = { fadeOut(spring(stiffness = Spring.StiffnessLow)) + slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Right, spring(stiffness = Spring.StiffnessLow)) }`;
content = content.replace(t4, r4);

fs.writeFileSync('app/src/main/java/com/example/AppNavigation.kt', content);
console.log("Patched AppNavigation.kt transitions");
