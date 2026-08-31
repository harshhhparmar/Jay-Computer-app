import re

with open('website_js.js', 'r') as f:
    text = f.read()

strings = re.findall(r'"([^"\\]{3,40})"', text)
words = set()
for s in strings:
    if len(s) > 3 and s.istitle() and not re.search(r'[{}:_;\/<>\-\[\]\(\)=!]', s):
        words.add(s)

for w in sorted(list(words)):
    if " " in w:
        print(w)
