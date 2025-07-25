def main():

    t = int(input())
    output = []
    for ind in range(t):
        n = int(input())
        s = input()
        
        if s.count('0') == n:
            output.append(str("0"))
            continue
        
        transitions = 0
        for i in range(1, n):
            if s[i] != s[i - 1]:
                transitions += 1
        
        res = transitions + (1 if s[0] == '1' else 0)
        output.append(str(res))

    print("\n".join(output))

if __name__ == "__main__":
    main()
