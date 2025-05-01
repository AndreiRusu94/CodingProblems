package second;

/*
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where s and t are divided into n and m substrings respectively, such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

Example 1:


Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
 */

public class Problem97 {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        Solution97 solution = new Solution97();
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}

class Solution97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();

        if (l1 + l2 != l3) {
            return false;
        }

        if (s1 == s3 || s2 == s3) {
            return true;
        }

        boolean[][] memo = new boolean[l1][l2];
        return dp(0, 0, 0, memo, s1, s2, s3);
    }

    private boolean dp(int i, int j, int k, boolean[][] memo, String s1, String s2, String s3) {
        if (k == s3.length()) {
            return true;
        }

        if (i < s1.length() && j < s2.length() && memo[i][j]) {
            return true;
        }

        boolean output = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            output = output || dp(i + 1, j, k + 1, memo, s1, s2, s3);
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            output = output || dp(i, j + 1, k + 1, memo, s1, s2, s3);
        }

        if (i < s1.length() && j < s2.length() && output) {
            memo[i][j] = output;
        }

        return output;
    }
}