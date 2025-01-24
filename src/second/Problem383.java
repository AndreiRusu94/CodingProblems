package second;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 */

import java.util.HashMap;
import java.util.Map;

public class Problem383 {

    public static void main(String[] args) {
        Solution383 solution = new Solution383();
        System.out.println("Can construct: " + solution.canConstruct("abc", "ahbgdc"));
    }
}

class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> availableLetters = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            availableLetters.compute(magazine.charAt(i), (k, v) -> (v == null) ? 1 : v + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            var currentLetter = ransomNote.charAt(i);
            if (availableLetters.containsKey(currentLetter)) {
                availableLetters.compute(currentLetter, (k, v) -> (v == null || v == 1) ? null : v - 1);
            } else {
                return false;
            }
        }

        return true;
    }
}
