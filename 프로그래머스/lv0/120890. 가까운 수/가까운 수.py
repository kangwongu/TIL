def solution(array, n):
    array.sort()
    temp = []

    for item in array:
        temp.append(abs(n-item))

    answer = array[temp.index(min(temp))]
    return answer