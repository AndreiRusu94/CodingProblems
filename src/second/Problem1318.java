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

public class Problem1318 {
    public static void main(String[] args) {
        Solution1318 solution = new Solution1318();

        System.out.println(solution.minFlips(2, 6, 5));
    }
}

class Solution1318 {
    public int minFlips(int a, int b, int c) {
        int aMask, bMask, cMask;
        int count = 0;
        while (a != 0 || b != 0 || c != 0) {
            aMask = a & 1;
            bMask = b & 1;
            cMask = c & 1;

            if (cMask == 0) {
                if (aMask != 0) {
                    count++;
                }
                if (bMask != 0) {
                    count++;
                }
            } else {
                if (aMask == 0 && bMask == 0) {
                    count++;
                }
            }

            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }

        return count;
    }
}
