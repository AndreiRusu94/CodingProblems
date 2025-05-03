package second;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 */

public class Problem392_2 {

    public static void main(String[] args) {
        Solution392_2 solution = new Solution392_2();
        System.out.println("Is subsequence: " + solution.isSubsequence("abc", "ahbgdc"));
    }
}

class Solution392_2 {
    public boolean isSubsequence(String s, String t) {
        int sourceCount = 0;
        if (t.length() < s.length()) {
            return false;
        }

        if (s.isEmpty()) {
            return true;
        }

        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(sourceCount) == t.charAt(i)) {
                sourceCount++;
            }

            if (sourceCount == s.length()) {
                return true;
            }
        }

        return false;
    }
}
