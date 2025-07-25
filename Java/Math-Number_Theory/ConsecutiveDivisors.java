package Java;

// Find the number of integers 1 < n < 10^7 , for which n and n + 1 have the same number of positive divisors. For example, 14
// has the positive divisors 1, 2, 7, 14 while 15 has 1, 3, 5, 15.

public class ConsecutiveDivisors {
    public static void main(String[] args) {
        int count = 0;
        int limit = 10000000;

        for (int n = 2; n < limit; n++) {
            if (hasSameNumberOfDivisors(n, n + 1)) {
                count++;
            }
        }

        System.out.println(
                "Number of integers between 1 and 10^7 where n and n+1 have the same number of divisors: " + count);
    }

    // Function to check if two numbers have the same number of divisors
    public static boolean hasSameNumberOfDivisors(int a, int b) {
        return countDivisors(a) == countDivisors(b);
    }

    // Function to count the number of divisors of a number
    public static int countDivisors(int n) {
        int count = 0;
        int sqrtN = (int) Math.sqrt(n);

        for (int i = 1; i <= sqrtN; i++) {
            if (n % i == 0) {
                count += 2; // Add both i and n/i as divisors
            }
        }

        // If n is a perfect square, we've counted the square root twice
        if (sqrtN * sqrtN == n) {
            count--;
        }

        return count;
    }
}
