package third;
/*
We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital, like "Google".
Given a string word, return true if the usage of capitals in it is right.

Example 1:

Input: word = "USA"
Output: true
Example 2:

Input: word = "FlaG"
Output: false
 
*/

public class Problem520 {
    public static void main(String[] args) {
        Solution520 solution = new Solution520();

        System.out.println(solution.detectCapitalUse("Google"));
    }
}


class Solution520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }

        if (Character.isUpperCase(word.charAt(0))) {
            boolean isFirstChar = Character.isUpperCase(word.charAt(1));
            for (int i = 2; i < word.length(); i++) {
                boolean currentChar = Character.isUpperCase(word.charAt(i));
                if (currentChar != isFirstChar) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }
}


