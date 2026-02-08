package third;
/*
Given an integer n, return the count of all numbers with unique digits, x, where 0 <= x < 10n.

Example 1:

Input: n = 2
Output: 91
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, excluding 11,22,33,44,55,66,77,88,99
Example 2:

Input: n = 0
Output: 1
*/

public class Problem357 {
    public static void main(String[] args) {
        Solution357 solution = new Solution357();

        System.out.println(solution.countNumbersWithUniqueDigits(2));
    }
}

class Solution357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }

        int total = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            total += uniqueDigits;
            availableNumber--;
        }

        return total;
    }

}

