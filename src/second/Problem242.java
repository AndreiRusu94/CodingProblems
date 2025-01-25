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

public class Problem242 {

    public static void main(String[] args) {
        Solution242 solution = new Solution242();
        System.out.println("Is anagram: " + solution.isAnagram("rat", "cat"));
    }
}

class Solution242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] letterCounts = new int[27];

        for (int i = 0; i < s.length(); i++) {
            letterCounts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            var c = t.charAt(i);
            if (letterCounts[c - 'a'] < 1) {
                return false;
            }

            letterCounts[c - 'a']--;
        }

        return true;
    }
}
