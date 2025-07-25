def count_reversible_numbers(limit):
    count = 0
    for i in range(1, limit):
        if is_reversible(i):
            count += 1
    return count

def is_reversible(n):
    if n % 10 == 0:  # Leading zero is not allowed
        return False
    
    reversed_n = int(str(n)[::-1])
    summed = n + reversed_n
    
    # Check if all digits in the sum are odd
    while summed > 0:
        digit = summed % 10
        if digit % 2 == 0:
            return False
        summed //= 10
    
    return True

limit = 1000000000
result = count_reversible_numbers(limit)
print("The number of reversible numbers below one billion is:", result)
