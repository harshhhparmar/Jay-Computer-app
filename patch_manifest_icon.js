const fs = require('fs');
let content = fs.readFileSync('app/src/main/AndroidManifest.xml', 'utf8');
content = content.replace('android:icon="@mipmap/ic_launcher"', 'android:icon="@drawable/jay_logo"');
content = content.replace('android:roundIcon="@mipmap/ic_launcher_round"', 'android:roundIcon="@drawable/jay_logo"');
fs.writeFileSync('app/src/main/AndroidManifest.xml', content);
console.log("Patched Manifest");
