package third;
/*
Given two strings, s1 and s2, the task is to find the length of the Longest Common Subsequence. If there is no common subsequence, return 0. 
A subsequence is a string generated from the original string by deleting 0 or more characters, without changing the relative order of the remaining
characters.

For example, subsequences of "ABC" are "", "A", "B", "C", "AB", "AC", "BC" and "ABC". In general, a string of length n has 2n subsequences.

Examples:

Input: s1 = "ABC", s2 = "ACD"
Output: 2
Explanation: The longest subsequence which is present in both strings is "AC".

Input: s1 = "AGGTAB", s2 = "GXTXAYB"
Output: 4
Explanation: The longest common subsequence is "GTAB".

Input: s1 = "ABC", s2 = "CBA"
Output: 1
Explanation: There are three longest common subsequences of length 1, "A", "B" and "C".
*/

public class ProblemDSA85 {
    public static void main(String[] args) {
        SolutionDSA85 solution = new SolutionDSA85();

        System.out.println(solution.longestCommonSubsequence("AGGTAB", "GXTXAYB"));
    }
}

class SolutionDSA85 {

    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}

