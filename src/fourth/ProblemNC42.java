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

import java.util.HashSet;
import java.util.Set;

public class ProblemNC42 {
    public static void main(String[] args) {
        SolutionNC42 solution = new SolutionNC42();
        System.out.println(solution.characterReplacement("XYYX", 2));
    }
}

class SolutionNC42 {

    public int characterReplacement(String s, int k) {
        Set<Character> chars = new HashSet<>();
        for (char c : s.toCharArray()) {
            chars.add(c);
        }

        int longest = 0;
        for (char c : chars) {
            int count = 0, l = 0;
            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) {
                    count++;
                }

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }

                longest = Math.max(longest, r - l + 1);
            }
        }

        return longest;
    }

}

