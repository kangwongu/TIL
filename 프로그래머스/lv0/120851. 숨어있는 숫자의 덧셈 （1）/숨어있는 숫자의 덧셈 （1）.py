def solution(my_string):
    answer = sum([(int(ch)) for ch in my_string if ch.isdigit()])
    return answer