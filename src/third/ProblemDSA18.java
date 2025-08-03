package third;
/*
Given a string s, the task is to check if it is palindrome or not.

Example:

Input: s = "abba"
Output: 1
Explanation: s is a palindrome

Input: s = "abc"
Output: 0
Explanation: s is not a palindrome
*/

public class ProblemDSA18 {
    public static void main(String[] args) {
        SolutionDSA18 solution = new SolutionDSA18();
        System.out.println(solution.isPalindrome("abba"));
    }
}

class SolutionDSA18 {

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
