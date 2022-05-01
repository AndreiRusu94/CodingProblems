package first;
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

public class Problem6 {
    public static void main(String[] args) {
        Solution6 solution = new Solution6();

        String input = "abcabcbteqteqtqetqrtqvtqetbqetbb";
        System.out.println(solution.convert(input, 4));
    }
}

class Solution6 {
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0) {
            return "";
        }

        Map<Integer, List<String>> map = new HashMap<>();
        int charCount = 0;

        do {
            for (int rowCount = 0; rowCount < numRows; rowCount++) {
                if (charCount < s.length()) {
                    map.computeIfAbsent(rowCount, emptyList -> new ArrayList<>())
                            .add(s.substring(charCount, charCount + 1));

                    charCount++;
                } else {
                    return generateConvertedString(map);
                }
            }

            for (int rowCount = numRows - 2; rowCount >= 1; rowCount--) {
                if (charCount < s.length()) {
                    map.computeIfAbsent(rowCount, emptyList -> new ArrayList<>())
                            .add(s.substring(charCount, charCount + 1));

                    charCount++;
                } else {
                    return generateConvertedString(map);
                }
            }

        } while (charCount < s.length());

        return generateConvertedString(map);
    }

    public String generateConvertedString(Map<Integer, List<String>> map) {
        StringBuilder sb = new StringBuilder();

        map.forEach((key, value) -> sb.append(String.join("", value)));

        return sb.toString();
    }
}