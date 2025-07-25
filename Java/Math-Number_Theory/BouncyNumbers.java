package Java;

// Working from left-to-right if no digit is exceeded by the digit to its left it is called an increasing number; for example, 134468.
// Similarly if no digit is exceeded by the digit to its right it is called a decreasing number; for example, 66420.
// We shall call a positive integer that is neither increasing nor decreasing a "bouncy" number; for example, 155349.
// Clearly there cannot be any bouncy numbers below one-hundred, but just over half of the numbers below one-thousand (525) are bouncy. In fact, the least number for which the proportion of bouncy numbers first reaches 50% is 538.
// Surprisingly, bouncy numbers become more and more common and by the time we reach 21780 the proportion of bouncy numbers is equal to 90%.
// Find the least number for which the proportion of bouncy numbers is exactly 99%.

public class BouncyNumbers {
    public static void main(String[] args) {
        int targetPercentage = 99;
        int number = 100;
        int bouncyCount = 0;

        while (true) {
            if (isBouncy(number))
                bouncyCount++;

            int currentPercentage = (bouncyCount * 100) / number;
            if (currentPercentage == targetPercentage) {
                System.out.println("The least number for which the proportion of bouncy numbers is exactly " +
                        targetPercentage + "% is " + number);
                break;
            }

            number++;
        }
    }

    public static boolean isBouncy(int n) {
        return !isIncreasing(n) && !isDecreasing(n);
    }

    public static boolean isIncreasing(int n) {
        String numStr = String.valueOf(n);
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) > numStr.charAt(i + 1))
                return false;
        }
        return true;
    }

    public static boolean isDecreasing(int n) {
        String numStr = String.valueOf(n);
        for (int i = 0; i < numStr.length() - 1; i++) {
            if (numStr.charAt(i) < numStr.charAt(i + 1))
                return false;
        }
        return true;
    }
}