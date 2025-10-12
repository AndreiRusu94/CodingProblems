package third;
/*
Give three strings s1, s2 and s3, determine if s3 is formed by interleaving s1 and s2.
A string s3 is an interleaving of s1 and s2 if:

It contains all characters of s1 and s2 while preserving their relative order.
Characters from s1 and s2 appear in s3 in the same order as in their original strings.
The length of s3 equals the combined length of s1 and s2.
Example

Input:  s1 = "AAB",  s2 = "AAC",  s3 =  "AAAABC",
Output: true
Explanation: The string "AAAABC" has all characters of the other two strings and in the same order.

Input:  s1 = "AB",  s2 = "C",  s3 =  "ACB",
Output: true
Explanation: s3 has all characters of s1 and s2 and retains order of characters of s1.

Input:  s1 = "YX",  s2 = "X", s3 = "XXY"
Output:  false
Explanation: "XXY " is not interleaved of "YX" and "X".  The strings that can be formed are YXX and XYX

*/

import java.util.Arrays;

public class ProblemDSA94 {
    public static void main(String[] args) {
        SolutionDSA94 solution = new SolutionDSA94();

        String s1 = "AAB";
        String s2 = "AAC";
        String s3 = "AAAABC";

        System.out.println(solution.isInterleaving(s1, s2, s3));
    }
}

class SolutionDSA94 {

    public boolean isInterleaving(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int n = s1.length();
        int m = s2.length();
        int[][] memo = new int[n + 1][m + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return isInterleavingRec(s1, s2, s3, 0, 0, memo);
    }

    private boolean isInterleavingRec(String s1, String s2, String s3, int i, int j, int[][] memo) {
        int n = s1.length();
        int m = s2.length();
        int k = i + j;

        if (i == n && j == m && k == s3.length()) {
            return true;
        }

        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean a = false;
        if (i < n && s1.charAt(i) == s3.charAt(k)) {
            a = isInterleavingRec(s1, s2, s3, i + 1, j, memo);
        }

        boolean b = false;
        if (j < m && s2.charAt(j) == s3.charAt(k)) {
            b = isInterleavingRec(s1, s2, s3, i, j + 1, memo);
        }

        memo[i][j] = a || b ? 1 : 0;
        return a || b;
    }

}

