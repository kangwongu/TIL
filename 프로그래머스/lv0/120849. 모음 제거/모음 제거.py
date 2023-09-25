def solution(my_string):
    answer = my_string
    m = ['a', 'e', 'i', 'o', 'u']
    
    for ch in m:
        answer = answer.replace(ch, '')

    return answer