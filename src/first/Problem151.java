package first;
/*
Given an input string, reverse the string word by word.



  Example 1:

    Input: "the sky is blue"
    Output: "blue is sky the"

  Example 2:

    Input: "  hello world!  "
    Output: "world! hello"
    Explanation: Your reversed string should not contain leading or trailing spaces.

  Example 3:

    Input: "a good   example"
    Output: "example good a"
    Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
*/

public class Problem151 {
    public static void main(String[] args) {
        Solution151 solution = new Solution151();

        System.out.println(solution.reverseWords("a good    example "));
    }
}

class Solution151 {
    public String reverseWords(String s) {
        String[] words = s.trim().replaceAll("\\s+", " ").split(" ");

        StringBuilder output = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            output.append(" ").append(words[i]);
        }

        return output.substring(1);
    }
}
