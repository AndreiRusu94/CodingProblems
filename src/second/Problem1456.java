package second;

/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
Example 3:

Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
 */

import java.util.Set;

public class Problem1456 {

    public static void main(String[] args) {
        Solution1456 solution = new Solution1456();
        System.out.println(solution.maxVowels("abciiidef", 3));
    }
}

class Solution1456 {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int currentVowels = 0;

        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
        }

        int maxVowels = currentVowels;

        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i - k))) {
                currentVowels--;
            }

            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }

            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }
}
