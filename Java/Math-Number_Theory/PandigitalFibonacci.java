package Java;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

// The Fibonacci sequence is defined by the recurrence relation:
// F(n) = F(n-1) + F(n-2). where F1 = 1 and F2 = 1.
// which the first nine digits are 1-9 pandigital.
// It turns out that F(541), which contains 113 digits, is the first Fibonacci number for which the last nine digits are 1-9 pandigital (contain all the digits 1 to 9, but not necessarily in order). And F(2749), which contains 575 digits, is the first Fibonacci number for which the first nine digits are pandigital.
// Given that Ik is the first Fibonacci number for which the first nine digits AND the last nine digits are 1-9 pandigital, find k.

public class PandigitalFibonacci {
    public static void main(String[] args) {
        int k = findK();
        System.out.println("The value of k is: " + k);
    }

    public static BigInteger fibonacciBigInteger(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }
        return b;
    }

    public static int findK() {
        int k = 329460;
        while (true) {
            BigInteger fib = fibonacciBigInteger(k);
            if (isPandigitalFirstAndLastNineDigits(fib)) {
                return k;
            }
            k++;
            System.out.println(k);
        }
    }

    public static boolean isPandigitalFirstAndLastNineDigits(BigInteger num) {
        String numStr = num.toString();
        if (numStr.length() < 18) {
            return false;
        }

        String firstNineDigits = numStr.substring(0, 9);
        String lastNineDigits = numStr.substring(numStr.length() - 9);

        return isPandigital(firstNineDigits) && isPandigital(lastNineDigits);
    }

    public static boolean isPandigital(String numStr) {
        Set<Character> digits = new HashSet<>();
        for (char c : numStr.toCharArray()) {
            if (c == '0') {
                return false; // No zero allowed
            }
            digits.add(c);
        }
        return digits.size() == 9;
    }
}
