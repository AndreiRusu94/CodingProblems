package second;

/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/

public class Problem344 {
    public static void main(String[] args) {
        Solution344 solution = new Solution344();

        solution.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}

class Solution344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;

        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}