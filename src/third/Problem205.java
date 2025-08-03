package third;

/*
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

Mapping 'e' to 'a'.
Mapping 'g' to 'd'.
Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true
 */

import java.util.HashMap;
import java.util.Map;

public class Problem205 {

    public static void main(String[] args) {
        Solution205 solution = new Solution205();
        System.out.println("Is isomorphic: " + solution.isIsomorphic("paper", "title"));
    }
}

class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> firstToSecondChar = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charInFirst = s.charAt(i);
            char charInSecond = t.charAt(i);

            if (firstToSecondChar.containsKey(charInFirst)) {
                if (!firstToSecondChar.get(charInFirst).equals(charInSecond)) {
                    return false;
                }
            } else {
                if (firstToSecondChar.containsValue(charInSecond)) {
                    return false;
                }
            }

            firstToSecondChar.put(charInFirst, charInSecond);
        }

        return true;
    }
}
