package third;
/*
Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.

if no such substring exists, return 0.

Example 1:

Input: s = "aaabb", k = 3
Output: 3
Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input: s = "ababbc", k = 2
Output: 5
Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

*/

import java.util.Arrays;

public class Problem395 {
    public static void main(String[] args) {
        Solution395 solution = new Solution395();

        System.out.println(solution.longestSubstring("ababbc", 2));
    }
}

class Solution395 {

    public int longestSubstring(String s, int k) {
        if (s.length() < k) {
            return 0;
        }

        int[] frequencies = new int[26];
        for (char c : s.toCharArray()) {
            frequencies[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (frequencies[s.charAt(i) - 'a'] < k) {
                int left = longestSubstring(s.substring(0, i), k);
                int right = longestSubstring(s.substring(i + 1), k);

                return Math.max(left, right);
            }
        }

        return s.length();
    }

}

