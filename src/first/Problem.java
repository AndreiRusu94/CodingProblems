package first;
/*
Print the common factors of two numbers
 */

public class Problem {
    public static void main(String[] args) {
        Solution solution = new Solution();

        solution.printCommonFactors(30, 300);
    }
}

class Solution {
    public void printCommonFactors(int firstNumber, int secondNumber) {
        int greatestCommonDivisor = getGreatestCommonDivisor(firstNumber, secondNumber);

        for (int i = 1; i <= Math.sqrt(greatestCommonDivisor); i++) {
            if (greatestCommonDivisor % i == 0) {
                System.out.println(i);

                if (greatestCommonDivisor != i * i) {
                    System.out.println(greatestCommonDivisor / i);
                }
            }
        }
    }

    private int getGreatestCommonDivisor(int firstNumber, int secondNumber) {
        while (firstNumber != secondNumber) {
            if (firstNumber > secondNumber) {
                firstNumber = firstNumber - secondNumber;
            } else {
                secondNumber = secondNumber - firstNumber;
            }
        }

        return secondNumber;
    }
}