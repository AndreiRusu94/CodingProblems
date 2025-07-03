package second;

/*
Given two strings s and t, return true if t is an
anagram
 of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */

public class Problem242_2 {

    public static void main(String[] args) {
        Solution242_2 solution = new Solution242_2();
        System.out.println("Is anagram: " + solution.isAnagram("rat", "cat"));
    }
}

class Solution242_2 {
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            countS[sChars[i] - 'a']++;
            countT[tChars[i] - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (countS[i] != countT[i]) {
                return false;
            }
        }

        return true;
    }
}
