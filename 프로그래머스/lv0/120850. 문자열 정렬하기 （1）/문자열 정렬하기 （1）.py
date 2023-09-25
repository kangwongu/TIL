import re

def solution(my_string):
    answer = []

    new_str = re.sub(r"[^0-9]", "", my_string)    
    answer = list(map(int,new_str))
    answer = sorted(answer)

    return answer