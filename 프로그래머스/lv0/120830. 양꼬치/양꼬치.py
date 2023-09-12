def solution(n, k):
    answer = 0
    free_drink = n//10

    ggochi = n*12000
    drink = (k-free_drink)*2000

    answer = ggochi + drink
    return answer