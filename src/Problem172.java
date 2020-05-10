/*
Given an integer n, return the number of trailing zeroes in n!.

  Example 1:

    Input: 3
    Output: 0
    Explanation: 3! = 6, no trailing zero.

  Example 2:

    Input: 5
    Output: 1
    Explanation: 5! = 120, one trailing zero.
*/

public class Problem172 {
    public static void main(String[] args) {
        Solution172 solution = new Solution172();

        System.out.println(solution.trailingZeroes(8));
    }
}


class Solution172 {
    public int trailingZeroes(int n) {
        return n >= 5 ? n / 5 + trailingZeroes(n / 5) : 0;
    }
}


