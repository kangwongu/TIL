def solution(my_string):
    return ''.join(ch.lower() if ch.isupper() else ch.upper() for ch in my_string)