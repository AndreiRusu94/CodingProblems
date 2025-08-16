package third;
/*
Given an input stream s consisting solely of lowercase letters, you are required to identify which character has appeared only once in the stream up to each point. If there are multiple characters that have appeared only once, return the one that first appeared. If no character has appeared only once, append '#' to the result.

Note: For each index i (0 <= i < n), you need to determine the result considering the substring from the start of the stream up to the i-th character.

Examples:

Input: s = "aabc"
Output: "a#bb"
Explanation:  For every ith character we will consider the string from index 0 till index i first non repeating character is as follow- "a" - first non-repeating character is 'a' "aa" - no non-repeating character so '#' "aab" - first non-repeating character is 'b' "aabc" - there are two non repeating characters 'b' and 'c',  first non-repeating character is 'b' because 'b' comes before 'c' in the stream.

Input: s = "bb"
Output: "b#"
Explanation: For every character first non repeating character is as follow- "b" - first non-repeating character is 'b' "bb" - no non-repeating character so '#'
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class ProblemDSA46 {
    public static void main(String[] args) {
        SolutionDSA46 solution = new SolutionDSA46();

        System.out.println(solution.firstNonRepeating("aabc"));
    }
}

class SolutionDSA46 {
    public String firstNonRepeating(String s) {
        int[] freq = new int[26];
        Deque<Character> oneTimeChars = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] == 1) {
                oneTimeChars.add(c);
            }

            while (!oneTimeChars.isEmpty() && freq[oneTimeChars.peek() - 'a'] != 1) {
                oneTimeChars.pop();
            }

            if (!oneTimeChars.isEmpty()) {
                output.append(oneTimeChars.peek());
            } else {
                output.append("#");
            }
        }

        return output.toString();
    }


}