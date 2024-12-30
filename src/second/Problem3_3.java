package second;

/*
Given a string s, find the length of the longest
substring
 without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class Problem3_3 {

    public static void main(String[] args) {
        Solution3_3 solution = new Solution3_3();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
    }
}

class Solution3_3 {
    public int lengthOfLongestSubstring(String s) {
        int longest = 0, i = 0;
        StringBuilder current = new StringBuilder();
        while (i < s.length()) {
            String newChar = s.substring(i, i + 1);
            int index = current.indexOf(newChar);
            if (current.indexOf(newChar) != -1) {
                current.delete(0, index + 1);
            }
            current.append(newChar);
            if (longest < current.length()) {
                longest = current.length();
            }
            i++;
        }

        return longest;
    }
}
