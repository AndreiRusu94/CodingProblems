package third;
/*
Given a string s, your task is to determine the length of the longest substring that lies between two identical characters in the string.
The substring should exclude the characters at the two ends. If no such pair of identical characters exists, return -1.

Examples:

Input: s = "accabbacc"
Output: 6
Explanation: The matching characters are 'c' at positions 1 and 8. Substring between them is "cabbac", of length 6.

Input: s = "aa"
Output: 0
Explanation: Matching characters 'a' are at positions 0 and 1. No characters in between, so length is 0.

Input: s = "abcd"
Output: -1
Explanation: No repeated characters exist, hence no valid substring between same characters.
*/

import java.util.HashMap;
import java.util.Map;

public class ProblemDSA19 {
    public static void main(String[] args) {
        SolutionDSA19 solution = new SolutionDSA19();
        System.out.println(solution.longestSubstring("accabbacc"));
    }
}

class SolutionDSA19 {

    public int longestSubstring(String s) {
        int maxLen = 0;
        Map<Character, Integer> charToFirstIndex = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (charToFirstIndex.containsKey(s.charAt(i))) {
                maxLen = Math.max(maxLen, i - charToFirstIndex.get(s.charAt(i)) - 1);
            } else {
                charToFirstIndex.put(s.charAt(i), i);
            }
        }


        return maxLen;
    }

}
