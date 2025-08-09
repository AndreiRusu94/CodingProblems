package third;

/*
Given a string s, the task is to check if it is a palindrome or not.

Examples:

Input: s = "abba"
Output: Yes
Explanation: s is a palindrome

Input: s = "abc"
Output: No
Explanation: s is not a palindrome
 */

public class ProblemDSA25 {

    public static void main(String[] args) {
        String s = "abc";
        SolutionDSA25 solution = new SolutionDSA25();
        System.out.println("Is palindrome: " + solution.isPalindrome(s));
    }
}

class SolutionDSA25 {
    public boolean isPalindrome(String s) {
        return isPalindromeUtil(s, 0, s.length() - 1);
    }

    private boolean isPalindromeUtil(String s, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalindromeUtil(s, left + 1, right - 1);
    }
}