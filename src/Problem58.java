/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.

If the last word does not exist, return 0.

Note: A word is defined as a maximal substring consisting of non-space characters only.

  Example:

    Input: "Hello World"
    Output: 5
 */

public class Problem58 {
    public static void main(String[] args) {
        Solution58 solution = new Solution58();

        String s = "Hello World";

        System.out.println(solution.lengthOfLastWord(s));
    }
}

class Solution58 {
    public int lengthOfLastWord(String s) {
        int len = s.length() - 1;

        while (len >= 0 && s.charAt(len) == ' ') {
            len--;
        }

        int lastWordLength = 0;
        while (len >= 0 && s.charAt(len) != ' ') {
            lastWordLength++;
            len--;
        }

        return lastWordLength;
    }
}

/*
Alternative solution

class Solution {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split.length >= 1 ? split[split.length - 1].length() : 0;
    }
}

 */