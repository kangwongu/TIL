def solution(my_string, letter):
    answer = ''
    for ch in my_string:
        if letter == ch:
            continue
        answer += ch

    return answer