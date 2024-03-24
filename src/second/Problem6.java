package second;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem6 {

    public static void main(String[] args) {
        Solution6 solution =  new Solution6();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}

class Solution6 {
    public String convert(String s, int numRows) {
        if (s == null || numRows == 1) {
            return s;
        }

        Map<Integer, List<String>> map = new HashMap<>();
        boolean forward = false;
        for (int i = 0; i < s.length(); i++) {
            if (i % (numRows - 1) == 0) {
                forward = !forward;
            }

            int key;
            if (forward) {
                key = i % (numRows - 1);
            } else {
                key = (numRows - 1) - i % (numRows - 1);
            }

            map.computeIfAbsent(key, ArrayList::new).add(s.substring(i, i + 1));
        }

        StringBuilder output = new StringBuilder();
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()) {
            entry.getValue().forEach(output::append);
        }

        return output.toString();
    }
}
