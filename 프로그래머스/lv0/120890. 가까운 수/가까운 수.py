def solution(array, n):
    array.sort()
    answer = array[0]
    target = abs(n - array[0])

    for i in range(1, len(array)):
        if abs(n-array[i]) < target:
            target = abs(n-array[i])
            answer = array[i]

    return answer
