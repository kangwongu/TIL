def solution(my_string):
    answer = sorted([int(ch) for ch in my_string if ch.isdigit()])
    return answer