const fs = require('fs');
let content = fs.readFileSync('app/src/main/res/values/themes.xml', 'utf8');
content = content.replace('<item name="windowSplashScreenAnimatedIcon">@drawable/jay_logo</item>', '<item name="windowSplashScreenAnimatedIcon">@drawable/splash_icon</item>');
fs.writeFileSync('app/src/main/res/values/themes.xml', content);
