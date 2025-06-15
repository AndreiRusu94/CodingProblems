package second;
/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 */


import java.util.Arrays;

public class Problem338 {
    public static void main(String[] args) {
        Solution338 solution = new Solution338();

        System.out.println(Arrays.toString(solution.countBits(10)));
    }
}

class Solution338 {
    public int[] countBits(int n) {
        int[] output = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int current = i, count = 0;
            while (current != 0) {
                count += current % 2;
                current = current / 2;
            }

            output[i] = count;
        }

        return output;
    }
}
