package second;
/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character

  Example 1:

    Input: word1 = "horse", word2 = "ros"
    Output: 3
    Explanation:
    horse -> rorse (replace 'h' with 'r')
    rorse -> rose (remove 'r')
    rose -> ros (remove 'e')

  Example 2:

    Input: word1 = "intention", word2 = "execution"
    Output: 5
    Explanation:
    intention -> inention (remove 't')
    inention -> enention (replace 'i' with 'e')
    enention -> exention (replace 'n' with 'x')
    exention -> exection (replace 'n' with 'c')
    exection -> execution (insert 'u')
 */


public class Problem72 {
    public static void main(String[] args) {
        Solution72 solution = new Solution72();

        System.out.println(solution.minDistance("teest", "tee"));
    }
}

class Solution72 {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }

        int n = word1.length(), m = word2.length();

        int[][] changes = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            changes[i][0] = i;
        }

        for (int i = 0; i <= m; i++) {
            changes[0][i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    changes[i + 1][j + 1] = changes[i][j];
                } else {
                    changes[i + 1][j + 1] = 1 + Math.min(changes[i][j], Math.min(changes[i][j + 1], changes[i + 1][j]));
                }
            }
        }

        return changes[n][m];
    }
}
