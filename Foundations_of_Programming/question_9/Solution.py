def interpret(value, commands, args):
    if len(commands) != len(args):
        return -1
    res = value
    for i in range(0, len(commands)):
        c = commands[i]
        if c == "+":
            res += args[i]
        elif c == "-":
            res -= args[i]
        elif c == "*":
            res *= args[i]
        else:
            return -1

    return res


print(interpret(1, ["+", "*"], [1, 3]))
