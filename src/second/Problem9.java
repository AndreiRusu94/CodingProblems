package second;
/*
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

  Example 1:
    Input: 121
    Output: true

  Example 2:
    Input: -121
    Output: false
    Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore, it is not a palindrome.

  Example 3:
    Input: 10
    Output: false
    Explanation: Reads 01 from right to left. Therefore, it is not a palindrome.
 */

public class Problem9 {
    public static void main(String[] args) {
        Solution9 solution = new Solution9();

        System.out.println(solution.isPalindrome(12121));
    }
}

class Solution9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0, initial = x;

        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }

        return (reverse == initial);
    }
}