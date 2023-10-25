def solution(array):
    answer = 0
    for num in str(array):
        for ch in num:
            if ch == '7':
                answer += 1
    return answer