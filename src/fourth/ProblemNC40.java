package fourth;
/*
Given a string s, find the length of the longest substring without duplicate characters.

A substring is a contiguous sequence of characters within a string.

Example 1:

Input: s = "zxyzxyz"

Output: 3
Explanation: The string "xyz" is the longest without duplicate characters.

Example 2:

Input: s = "xxxx"

Output: 1
*/

import java.util.HashMap;
import java.util.Map;

public class ProblemNC40 {
    public static void main(String[] args) {
        SolutionNC40 solution = new SolutionNC40();
        System.out.println(solution.lengthOfLongestSubstring("zxyzxyz"));
    }
}

class SolutionNC40 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToIndex = new HashMap<>();

        int longest = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            if (charToIndex.containsKey(s.charAt(r))) {
                l = Math.max(charToIndex.get(s.charAt(r)) + 1, l);
            }
            charToIndex.put(s.charAt(r), r);
            longest = Math.max(longest, r - l + 1);
        }

        return longest;
    }

}

