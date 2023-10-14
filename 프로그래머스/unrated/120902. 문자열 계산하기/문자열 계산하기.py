def solution(my_string):
    array = my_string.split()
    answer = int(array[0])

    for i in range(1,len(array),2):
        if array[i]=='+':
            answer+=int(array[i+1])
        else:
            answer-=int(array[i+1])
    
    return answer