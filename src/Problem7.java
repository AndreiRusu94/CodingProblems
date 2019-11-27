/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);

  Example 1:
    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"

  Example 2:
    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"

Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem7 {
    public static void main(String[] args) {
        Solution7 solution = new Solution7();

        System.out.println(solution.reverse(2512315));
    }
}

class Solution7 {
    public int reverse(int x) {
        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE) {
            return 0;
        }

        int r = 0;

        while (x != 0) {
            int left = x % 10;
            x /= 10;

            if (r > Integer.MAX_VALUE/10 || r < Integer.MIN_VALUE/10) return 0;
            r = r * 10 + left;
        }

        return r;
    }
}