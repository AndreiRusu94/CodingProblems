package second;
/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "IceCreAm"

Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:

Input: s = "leetcode"

Output: "leotcede"

Constraints:

1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
 */

import java.util.Set;

public class Problem345 {
    public static void main(String[] args) {
        Solution345 solution = new Solution345();

        System.out.println(solution.reverseVowels("AswsnaBcIe"));
    }
}

class Solution345 {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] letters = s.toCharArray();

        while (left < right) {
            while (left < right && !vowels.contains(letters[left])) {
                left++;
            }

            while (left < right && !vowels.contains(letters[right])) {
                right--;
            }

            char temp = letters[left];
            letters[left] = letters[right];
            letters[right] = temp;

            left++;
            right--;
        }

        return new String(letters);
    }
}
