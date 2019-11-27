/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

  Example 1:
    Input: "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.

  Example 2:
    Input: "cbbd"
    Output: "bb"
 */

public class Problem5 {
    public static void main(String[] args) {
        Solution5 solution = new Solution5();

        String input = "abcabcbteqteqtqetqrtqvtqetbqetbb";
        System.out.println(solution.longestPalindrome(input));
    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int window = s.length();

        while (window >= 0) {
            for (int i = 0; i < s.length() - window; i++) {
                String currentString = s.substring(i, i + window + 1);
                int currentStringLength = currentString.length();
                boolean isPalindrome = true;

                for (int j = 0; j < currentStringLength / 2; j++) {
                    if (currentString.charAt(j) != currentString.charAt(currentStringLength - j - 1)) {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome) {
                    return currentString;
                }
            }

            window--;
        }

        return "";
    }
}