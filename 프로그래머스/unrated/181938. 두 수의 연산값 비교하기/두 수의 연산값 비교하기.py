def solution(a, b):
    result1 = int(str(a)+str(b))
    result2 = 2*(a*b)
    
    if result1 == result2:
        answer = result1
        return answer
    
    answer = max(result1, result2)
    return answer