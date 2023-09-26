def solution(s):
    stack = []
    for ch in s.split():
        if ch != 'Z':
            stack.append(int(ch))
        else:
            stack.pop()

    return sum(stack)