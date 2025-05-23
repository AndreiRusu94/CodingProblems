package second;

/*
Given a string s, return the longest palindromic substring in s.

 */

public class Problem5_5_5 {

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        Solution5_5_5 solution = new Solution5_5_5();
        System.out.println(solution.longestPalindrome(s));
    }
}

class Solution5_5_5 {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            String odd = expandAroundCenter(s, i, i);
            String even = expandAroundCenter(s, i, i + 1);

            if (odd.length() > maxStr.length()) {
                maxStr = odd;
            }

            if (even.length() > maxStr.length()) {
                maxStr = even;
            }
        }

        return maxStr;
    }

    private String expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}