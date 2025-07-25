def main():

    t = int(input())
    output = []
    for _ in range(t):
        n = int(input())
        s = input().replace(" ", "")
        
        if n == 1:
            output.append(str("1 1"))
            continue
        elif not s or s == s[0]*n:
            output.append(str("0"))
            continue
        
        l = 0
        r = n - 1
        max_score = 0
        shortest_len = 0
        for i in range(n):
            for j in range(i, n):
                modified_s = s[:i] + s[j+1:]
                score = len(modified_s) - len(set(modified_s))
                if score > max_score or (score == max_score and len(modified_s) < shortest_len):
                    max_score = score
                    shortest_len = len(modified_s)
                    l, r = i + 1, j + 1
        res = f"{l} {r}"
        output.append(str(res))

    print("\n".join(output))

if __name__ == "__main__":
    main()