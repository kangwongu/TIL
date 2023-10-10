def solution(order):
    answer = 0
    target = [3, 6, 9]
    for num in str(order):
        if int(num) in target:
            answer += 1
    return answer