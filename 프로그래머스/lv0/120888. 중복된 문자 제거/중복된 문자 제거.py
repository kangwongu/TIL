def solution(my_string):
    answer = ''
    for i in range(len(my_string)):
        if my_string.find(my_string[i]) == i:
            print(my_string.find(my_string[i]))
            answer += my_string[i]
            
    return answer