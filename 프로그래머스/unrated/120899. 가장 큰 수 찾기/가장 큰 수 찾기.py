def solution(array):
    sorted_array = sorted(array)
    max = sorted_array[len(sorted_array)-1]

    return [max, array.index(max)]