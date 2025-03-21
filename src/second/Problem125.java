package second;

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

 */

public class Problem125 {
    public static void main(String[] args) {
        Solution125 sol = new Solution125();
        System.out.println("Is palindrome: " + sol.isPalindrome("Marge, let's \\\"[went].\\\" I await {news} telegram."));
    }
}

class Solution125 {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i <= j) {
            char leftChar = Character.toLowerCase(s.charAt(i));
            char rightChar = Character.toLowerCase(s.charAt(j));
            while (i < j && !Character.isLetterOrDigit(leftChar)) {
                i++;
                leftChar = Character.toLowerCase(s.charAt(i));
            }

            while (i < j && !Character.isLetterOrDigit(rightChar)) {
                j--;
                rightChar = Character.toLowerCase(s.charAt(j));
            }

            if (leftChar != rightChar) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }
}