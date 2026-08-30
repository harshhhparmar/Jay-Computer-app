const fs = require('fs');
let content = fs.readFileSync('app/src/main/java/com/example/MoreScreens.kt', 'utf8');

if (!content.includes('import androidx.compose.foundation.text.KeyboardOptions')) {
    content = content.replace('import androidx.compose.material3.*', 'import androidx.compose.material3.*\nimport androidx.compose.foundation.text.KeyboardOptions\nimport androidx.compose.ui.text.input.KeyboardType\nimport androidx.compose.ui.text.input.ImeAction');
}

const targetName = `            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Full Name") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
            )`;
            
const replaceName = `            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Full Name") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Next),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
            )`;
content = content.replace(targetName, replaceName);

const targetMobile = `            OutlinedTextField(
                value = mobile,
                onValueChange = { mobile = it },
                label = { Text("Mobile Number") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
            )`;
            
const replaceMobile = `            OutlinedTextField(
                value = mobile,
                onValueChange = { if (it.length <= 15 && it.all { char -> char.isDigit() || char == '+' }) mobile = it },
                label = { Text("Mobile Number") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone, imeAction = ImeAction.Next),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
            )`;
content = content.replace(targetMobile, replaceMobile);

const targetMessage = `            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Message (Optional)") },
                modifier = Modifier.fillMaxWidth().height(120.dp),
                maxLines = 4,
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
            )`;
const replaceMessage = `            OutlinedTextField(
                value = message,
                onValueChange = { message = it },
                label = { Text("Message (Optional)") },
                modifier = Modifier.fillMaxWidth().height(120.dp),
                maxLines = 4,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
            )`;
content = content.replace(targetMessage, replaceMessage);

content = content.replace('.padding(horizontal = 16.dp, vertical = 12.dp),', '.padding(horizontal = 16.dp, vertical = 12.dp).imePadding(),');
content = content.replace('enabled = name.isNotBlank() && mobile.isNotBlank(),', 'enabled = name.isNotBlank() && mobile.length >= 10,');

fs.writeFileSync('app/src/main/java/com/example/MoreScreens.kt', content);
console.log("Patched MoreScreens.kt safely");
