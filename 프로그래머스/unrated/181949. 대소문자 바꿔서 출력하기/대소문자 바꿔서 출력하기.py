str = input()

for s in str:
    if s.islower():
        print(s.upper(), end='')
    else:
        print(s.lower(), end='')