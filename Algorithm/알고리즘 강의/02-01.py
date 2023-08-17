input1 = int(input())
input2 = list(map(int, input().split()))

answer = []
answer.append(input2[0])

for i in range(len(input2)-1):
    if input2[i] < input2[i+1]:
        answer.append(input2[i+1])

for ch in answer:
    print(ch,end=' ')