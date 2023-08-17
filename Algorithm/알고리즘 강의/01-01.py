input1 = str(input())
input2 = str(input())

input1 = input1.lower()
input2 = input2.lower()

count = 0

for ch in input1:
    if ch == input2:
        count += 1

print(count)