def solution(my_string):
    answer = ''
    string = ['a', 'e', 'i', 'o', 'u']

    for ch in my_string:
        if ch not in string:
            answer += ch

    return answer