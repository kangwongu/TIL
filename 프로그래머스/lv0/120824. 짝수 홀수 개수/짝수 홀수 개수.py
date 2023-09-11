def solution(num_list):
    answer = []
    even, odd = 0, 0
    for num in num_list:
        if num%2==0:
            even += 1
            continue
        odd += 1
    
    answer.append(even)
    answer.append(odd)

    return answer