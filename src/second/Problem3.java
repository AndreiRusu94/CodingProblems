package second;

/*
Given a string s, find the length of the longest substring without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*/

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        String input = "abcabcbb";
        System.out.println((solution.lengthOfLongestSubstring(input)));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> substring = new HashSet<>();

        int longestLength = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!substring.contains(s.charAt(j))) {
                substring.add(s.charAt(j++));
                longestLength = Math.max(longestLength, j - i);
            } else {
                substring.remove(s.charAt(i++));
            }
        }

        return longestLength;
    }
}