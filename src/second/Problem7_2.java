package second;

/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21
 */

public class Problem7_2 {
    public static void main(String[] args) {
        Solution7_2 solution = new Solution7_2();
        System.out.println(solution.reverse(12345));
    }
}

class Solution7_2 {
    public int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            if (reverse > Integer.MAX_VALUE/10 || reverse < Integer.MIN_VALUE/10) {
                return 0;
            }

            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }

        return reverse;
    }
}