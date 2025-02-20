package second;
/*
Given two binary strings a and b, return their sum as a binary string.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/

public class Problem67 {
    public static void main(String[] args) {
        Solution67 solution = new Solution67();

        System.out.println(solution.addBinary("1010", "1011"));
    }
}

class Solution67 {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder output = new StringBuilder();

        int carry = 0;
        while (i >= 0 || j >=0) {
            int valueA = (i < 0) ? 0 : (int) a.charAt(i) - '0';
            int valueB = (j < 0) ? 0 : (int) b.charAt(j) - '0';

            int value = carry + valueA + valueB;
            carry = value / 2;

            i--;
            j--;
            output.append(value % 2);
        }

        if (carry != 0) {
            output.append(carry);
        }
        return output.reverse().toString();
    }
}
