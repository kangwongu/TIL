input1 = int(input())
input2 = list(map(int, input().split()))
input3 = int(input())
input4 = list(map(int, input().split()))

l, r = 0, 0
answer = []

input2.sort()
input4.sort()

# for ch in input2:
#     print(ch, end=' ')

# for ch in input4:
#     print(ch, end=' ')

while l<input1 and r<input3:
    if input2[l] < input4[r]:
        l += 1
    elif input4[r] < input2[l]:
        r += 1
    else:
        answer.append(input2[l])
        l += 1
        r += 1

for ch in answer:
    print(ch, end=' ')