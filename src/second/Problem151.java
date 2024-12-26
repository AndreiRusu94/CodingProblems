package second;

/*
Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class Problem151 {

    public static void main(String[] args) {
        Solution151 solution = new Solution151();
        String str = "F R  I   E    N     D      S      ";
        System.out.println(solution.reverseWords(str));
    }
}

class Solution151 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder currentWord = new StringBuilder();
        String output = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                if (i != 0 && s.charAt(i - 1) == ' ') {
                    output = currentWord + " " + output;
                    currentWord.setLength(0);
                }
                if (i == s.length() - 1) {
                    currentWord.append(s.charAt(i));
                    return (currentWord + " " + output).trim();
                }
                currentWord.append(s.charAt(i));
            }
        }

        return output;
    }
}