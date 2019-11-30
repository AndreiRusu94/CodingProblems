/*
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note:

Only the space character ' ' is considered as whitespace character.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.

  Example 1:
    Input: "42"
    Output: 42

  Example 2:
    Input: "   -42"
    Output: -42
    Explanation: The first non-whitespace character is '-', which is the minus sign.
                 Then take as many numerical digits as possible, which gets 42.

  Example 3:
    Input: "4193 with words"
    Output: 4193
    Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

  Example 4:
    Input: "words and 987"
    Output: 0
    Explanation: The first non-whitespace character is 'w', which is not a numerical
                 digit or a +/- sign. Therefore no valid conversion could be performed.

  Example 5:
    Input: "-91283472332"
    Output: -2147483648
    Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
                 Thefore INT_MIN (−231) is returned.
 */

import java.util.Arrays;
import java.util.List;

public class Problem8 {
    public static void main(String[] args) {
        Solution8 solution = new Solution8();

        System.out.println(solution.myAtoi("   -42"));
    }
}

class Solution8 {

    public int myAtoi(String str) {
        if (str == null || str.length() == 0 || "-".equals(str) || "+".equals(str)) {
            return 0;
        }

        List<String> numbers = Arrays.asList("0", "1", "2", "3","4","5","6","7","8", "9");

        str = str.trim();

        if (str == null || str.length() == 0) {
            return 0;
        }

        String sign;
        StringBuilder output = new StringBuilder();

        if (hasSign(str)) {
            sign = str.substring(0, 1);
            str = str.substring(1);
            sign = "-".equals(sign) ? sign : "";
        } else {
            sign = "";
        }

        if (!numbers.contains(str.substring(0, 1))) {
            return 0;
        }

        str = resolveZeros(str);

        if (str == null || str.length() == 0) {
            return 0;
        }

        int currentChar = 0;
        while (currentChar < str.length()) {
            String charAsString = str.substring(currentChar, currentChar + 1);

            if (numbers.contains(charAsString)) {
                output.append(charAsString);
            } else {
                if (output.toString().length() > 0) {
                    return generateOutput(sign, output, currentChar);
                } else {
                    return 0;
                }
            }

            currentChar++;
        }

        return generateOutput(sign, output, currentChar);
    }

    public boolean hasSign(String s) {
        return s.substring(0, 1).equals("+") || s.substring(0, 1).equals("-");
    }

    public String resolveZeros(String s) {
        int currentChar = 0;

        while("0".equals(s.substring(currentChar, currentChar + 1))) {
            currentChar++;
            if(currentChar == s.length()) {
                return "";
            }
        }

        return s.substring(currentChar);
    }


    private int generateOutput(String sign, StringBuilder output, int currentChar) {
        if (currentChar >= 10) {
            if (currentChar <= 12) {
                long solution = Long.parseLong(output.toString());

                if (solution <= Integer.MAX_VALUE && solution >= Integer.MIN_VALUE) {
                    return Integer.valueOf(sign + output.toString());
                }

                if ("-".equals(sign)) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            } else {
                if ("-".equals(sign)) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        } else {
            return Integer.valueOf(sign + output.toString());
        }
    }
}