const fs = require('fs');

function replaceFile(path, replacements) {
    let content = fs.readFileSync(path, 'utf8');
    for (let r of replacements) {
        content = content.replace(new RegExp(r.from, 'g'), r.to);
    }
    fs.writeFileSync(path, content);
}

replaceFile('app/src/main/java/com/example/HomeScreens.kt', [
    { from: 'quadraticBezierTo', to: 'quadraticTo' }
]);

replaceFile('app/src/main/java/com/example/MoreScreens.kt', [
    { from: 'Icons.Default.Send', to: 'Icons.AutoMirrored.Filled.Send' },
    { from: '\\.menuAnchor\\(\\)', to: '.menuAnchor()' } // leave menuAnchor for now
]);

replaceFile('app/src/main/java/com/example/ServiceDetailsScreen.kt', [
    { from: 'Icons.Default.ArrowBack', to: 'Icons.AutoMirrored.Filled.ArrowBack' },
    { from: 'Icons.Default.Message', to: 'Icons.AutoMirrored.Filled.Message' }
]);

replaceFile('app/src/main/java/com/example/ServicesData.kt', [
    { from: 'Icons.Default.MenuBook', to: 'Icons.AutoMirrored.Filled.MenuBook' },
    { from: 'Icons.Default.TrendingUp', to: 'Icons.AutoMirrored.Filled.TrendingUp' },
    { from: 'Icons.Default.Article', to: 'Icons.AutoMirrored.Filled.Article' }
]);

console.log("Warnings patched.");
