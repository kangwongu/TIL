def solution(rsp):
    answer = ''
    to_win = {'2':'0', '0':'5', '5':'2'}

    for ch in rsp:
        answer += to_win[ch]
    return answer