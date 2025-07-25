def is_pandigital(n):
    # Check if a number is pandigital (contains all digits from 1 to 9)
    return sorted(str(n)) == ['1', '2', '3', '4', '5', '6', '7', '8', '9']

def find_pandigital_fibonacci():
    # Initial Fibonacci values
    a, b = 1, 1
    k = 2  # k starts from 2 because we already know the first two Fibonacci numbers
    while True:
        # Generate next Fibonacci number
        a, b = b, a + b
        k += 1

        # Check if last 9 digits are pandigital
        if is_pandigital(b % 10**9):
            # Check if first 9 digits are pandigital
            first_digits = int(str(b)[:9])
            if is_pandigital(first_digits):
                return k

# Find the value of k
k = find_pandigital_fibonacci()
print(k)
