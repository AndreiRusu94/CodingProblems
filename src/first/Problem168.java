package first;
/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...

  Example 1:

    Input: 1
    Output: "A"

  Example 2:

    Input: 28
    Output: "AB"

  Example 3:

    Input: 701
    Output: "ZY"
*/

public class Problem168 {
    public static void main(String[] args) {
        Solution168 solution = new Solution168();

        System.out.println(solution.convertToTitle(9));
    }
}


class Solution168 {
    private static final char FIRST_CHAR = 'A';

    public String convertToTitle(int n) {
        StringBuilder output = new StringBuilder();

        while (n != 0) {
            n--;
            output.append((char) (FIRST_CHAR + n % 26));
            n /= 26;
        }

        return output.reverse().toString();
    }
}


