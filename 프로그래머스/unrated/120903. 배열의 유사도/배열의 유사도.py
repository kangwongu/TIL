def solution(s1, s2):
    answer = 0
    for ch1 in s1:
        if ch1 in s2:
            answer += 1
    return answer