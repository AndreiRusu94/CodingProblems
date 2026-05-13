package fourth;
/*
You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace 
them with any other uppercase English character.

After performing at most k replacements, return the length of the longest substring which contains only one distinct character.

Example 1:

Input: s = "XYYX", k = 2

Output: 4
Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.

Example 2:

Input: s = "AAABABB", k = 1

Output: 5
*/

import java.util.HashMap;
import java.util.Map;

public class ProblemNC41 {
    public static void main(String[] args) {
        SolutionNC41 solution = new SolutionNC41();
        System.out.println(solution.characterReplacement("XYYX", 2));
    }
}

class SolutionNC41 {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charToFreq = new HashMap<>();

        int longest = 0, l = 0, maxFreq = 0;
        for (int r = 0; r < s.length(); r++) {
            charToFreq.put(s.charAt(r),
                    charToFreq.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, charToFreq.get(s.charAt(r)));

            while ((r - l + 1) - maxFreq > k) {
                charToFreq.put(s.charAt(l), charToFreq.get(s.charAt(l)) - 1);
                l++;
            }

            longest = Math.max(longest, r - l + 1);

        }

        return longest;
    }

}

