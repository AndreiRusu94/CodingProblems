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

public class Problem392 {

    public static void main(String[] args) {
        Solution392 solution = new Solution392();
        System.out.println("Is subsequence: " + solution.isSubsequence("abc", "ahbgdc"));
    }
}

class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        if (sLength == 0) {
            return true;
        }

        int i = 0, j = 0;

        while (j < t.length() && i < sLength) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == sLength;
    }
}
