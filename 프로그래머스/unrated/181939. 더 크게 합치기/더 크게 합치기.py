def solution(a, b):
    result1 = str(a)+str(b)
    result2 = str(b)+str(a)

    if (int(result1) > int(result2)):
        answer = result1
    else :
        answer = result2

    return int(answer)