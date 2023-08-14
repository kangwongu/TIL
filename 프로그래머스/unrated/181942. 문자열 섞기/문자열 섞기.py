def solution(str1, str2):
    answer = ''
    for ch1, ch2 in zip(str1, str2):
        answer += (ch1+ch2)      

    return answer