def solution(my_string, overwrite_string, s):
    answer = my_string[:s]
    answer = answer + overwrite_string
    answer = answer + my_string[s+len(overwrite_string):]
    return answer