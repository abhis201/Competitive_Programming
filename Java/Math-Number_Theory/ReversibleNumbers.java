package Java;

// Some positive integers n have the property that the sum In + reverse(n), consists entirely of odd (decimal) digits. For instance,
// 36 + 63 = 99 and 409 + 904 = 1313. We will call such numbers reversible; so 36, 63, 409, and 904 are reversible. Leading
// zeroes are not allowed in either n or reverse (n).
// There are 120 reversible numbers below one-thousand.
// How many reversible numbers are there below one-billion?

public class ReversibleNumbers {
    public static void main(String[] args) {
        int limit = 1_000_000_000;
        int count = countReversibleNumbers(limit);
        System.out.println("The number of reversible numbers below one billion is: " + count);
    }

    public static int countReversibleNumbers(int limit) {
        int count = 0;
        for (int i = 1; i < limit; i++) {
            if (isReversible(i))
                count++;
        }
        return count;
    }

    public static boolean isReversible(int n) {
        if (n % 10 == 0) // Leading zero is not allowed
            return false;

        int reversed = reverseNumber(n);
        int sum = n + reversed;

        // Check if all digits in the sum are odd
        while (sum > 0) {
            int digit = sum % 10;
            if (digit % 2 == 0)
                return false;
            sum /= 10;
        }

        return true;
    }

    public static int reverseNumber(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }
}
