def solution(n):
    answer = 0
    for i in range(1, n+1):
        if i%2!=0:
            continue
        answer += i

    return answer