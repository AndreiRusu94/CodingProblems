package first;
/*
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It's guaranteed the answer fits on a 32-bit signed integer.

  Example 1:

    Input: S = "rabbbit", T = "rabbit"
    Output: 3
    Explanation:
    As shown below, there are 3 ways you can generate "rabbit" from S.
    (The caret symbol ^ means the chosen letters)

    rabbbit
    ^^^^ ^^
    rabbbit
    ^^ ^^^^
    rabbbit
    ^^^ ^^^

  Example 2:

    Input: S = "babgbag", T = "bag"
    Output: 5
    Explanation:
    As shown below, there are 5 ways you can generate "bag" from S.
    (The caret symbol ^ means the chosen letters)

    babgbag
    ^^ ^
    babgbag
    ^^    ^
    babgbag
    ^    ^^
    babgbag
      ^  ^^
    babgbag
        ^^^
*/

public class Problem115 {
    public static void main(String[] args) {
        Solution115 solution = new Solution115();

        System.out.println(solution.numDistinct("rabbbbit", "rabbit"));
    }
}

class Solution115 {
    public int numDistinct(String s, String t) {
        int[][] matrix = new int[t.length() + 1][s.length() + 1];

        for (int i = 0; i <= s.length(); i++) {
            matrix[0][i] = 1;
        }

        for (int i = 0; i < t.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    matrix[i + 1][j + 1] = matrix[i][j] + matrix[i + 1][j];
                } else {
                    matrix[i + 1][j + 1] = matrix[i + 1][j];
                }
            }
        }

        return matrix[t.length()][s.length()];
    }
}
