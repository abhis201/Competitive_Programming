from typing import List

def findIndex(nums: List[int])->int:
    r = len(nums)
    while r>0:
        if nums[r-1] < 0:
            return r
        r-=1
    return 0

def main():

    t = int(input())
    output = []
    for _ in range(t):
        n = int(input())

        nums = []
        prefix = []
        val = 0

        for i in range(n):
            x = int(input())
            nums.append(x)
            val += x
            prefix.append(val)

        
        if n == 1:
            output.append(str("1"))
            continue
        
        l = 0
        r = n
        score = 0
        while l <= r:
            m = findIndex(nums[l:r])
            if prefix[m-1] == 0:
                score += 1
        
        res = f"{l} {r}"
        output.append(str(res))

    print("\n".join(output))

main()