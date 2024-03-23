package second;

/*
Given a string s, return the longest palindromic substring in s.
 */

public class Problem5 {

    public static void main(String[] args) {
        String s = "aacabdkacaa";
        Solution5 solution = new Solution5();
        System.out.println(solution.longestPalindrome(s));
    }
}

class Solution5 {
    public String longestPalindrome(String s) {

        int maxLength = 1;
        String output = s.substring(0, 1);

        for (int i = 0; i < s.length() - 1; i++) {
            if (i + maxLength < s.length()) {
                StringBuilder sb = new StringBuilder(s.substring(i, i + maxLength));
                for (int j = i + maxLength; j < s.length(); j++) {
                    sb.append(s, j, j + 1);
                    if (sb.charAt(0) != sb.charAt(sb.length() - 1)) {
                        continue;
                    }

                    StringBuilder intermediary = new StringBuilder(sb);
                    if (intermediary.reverse().toString().equals(sb.toString())) {
                        maxLength = sb.length();
                        output = sb.toString();
                    }
                }
                sb.deleteCharAt(0);
            } else {
                break;
            }
        }

        return output;
    }
}