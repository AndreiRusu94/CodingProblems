import java.util.*;

/*
Given a string, find the length of the longest substring without repeating characters.

  Example 1:
    Input: "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

  Example 2:
    Input: "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

  Example 3:
    Input: "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
                 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Problem3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        String input = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(input));
    }
}

class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int longestLength = 0, i = 0, j = 0;

        Set<Character> set = new HashSet<>();

        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                longestLength = Math.max(longestLength, j - i);

            } else {
                set.remove(s.charAt(i++));
            }
        }

        return longestLength;
    }
}