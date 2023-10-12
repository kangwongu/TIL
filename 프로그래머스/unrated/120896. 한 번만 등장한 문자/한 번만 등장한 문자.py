def solution(s):
    answer = ''

    for ch in s:
        if s.count(ch) == 1:
            answer += ch
        
    return ''.join(sorted(answer))