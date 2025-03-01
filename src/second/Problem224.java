package second;

/*
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

Example 1:

Input: s = "1 + 1"
Output: 2
Example 2:

Input: s = " 2-1 + 2 "
Output: 3
Example 3:

Input: s = "(1+(4+5+2)-3)+(6+8)"
Output: 23


Constraints:

1 <= s.length <= 3 * 105
s consists of digits, '+', '-', '(', ')', and ' '.
s represents a valid expression.
'+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
'-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
There will be no two consecutive operators in the input.
Every number and running calculation will fit in a signed 32-bit integer.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem224 {

    public static void main(String[] args) {
        Solution224 solution = new Solution224();
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(s + " = " + solution.calculate(s));
    }
}

class Solution224 {
    public int calculate(String s) {
        if (s == null) {
            return 0;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        int sign = 1;
        int result = 0;
        int number = 0;

        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (c == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        if (number != 0) {
            result += sign * number;
        }

        return result;
    }
}
