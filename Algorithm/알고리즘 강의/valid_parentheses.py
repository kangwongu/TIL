def is_valid(str):
    stack = []
    for ch in str:
        if ch == '(':
            stack.append(')')
        elif ch == '[':
            stack.append(']')
        elif ch == '{':
            stack.append('}')
        elif not stack  or stack.pop() != ch:
            return False
    return not stack

print(is_valid("}({[()]})"))