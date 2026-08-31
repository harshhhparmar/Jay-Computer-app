import re

with open('website_js.js', 'r') as f:
    content = f.read()

# Try to find the services array
matches = re.findall(r'\{id:"([^"]+)",categoryEn:"([^"]+)",categoryGu:"([^"]+)",titleEn:"([^"]+)",titleGu:"([^"]+)",iconName:"([^"]+)",descriptionEn:"([^"]+)",descriptionGu:"([^"]+)",documentsEn:\[(.*?)\],documentsGu:\[(.*?)\]\}', content)

print(f"Found {len(matches)} services")
for m in matches:
    print(m[0], m[3], m[4])
