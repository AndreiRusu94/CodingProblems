package first;
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

  Example 1:

    Input: "A man, a plan, a canal: Panama"
    Output: true

  Example 2:

    Input: "race a car"
    Output: false
*/

public class Problem125 {
    public static void main(String[] args) {
        Solution125 solution = new Solution125();

        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }
}

class Solution125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.trim().length() == 0 || s.trim().length() == 1) {
            return true;
        }

        int left = 0, right = s.length() - 1;

        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            while (!Character.isLetterOrDigit(leftChar) && left < right) {
                left++;
                leftChar = Character.toLowerCase(s.charAt(left));
            }

            while (!Character.isLetterOrDigit(rightChar) && left < right) {
                right--;
                rightChar = Character.toLowerCase(s.charAt(right));
            }

            if (left < right && leftChar != rightChar) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
