package first;
/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.

  Example 1:

    Input: ["2", "1", "+", "3", "*"]
    Output: 9
    Explanation: ((2 + 1) * 3) = 9

  Example 2:

    Input: ["4", "13", "5", "/", "+"]
    Output: 6
    Explanation: (4 + (13 / 5)) = 6

  Example 3:

    Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
    Output: 22
    Explanation:
      ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
    = ((10 * (6 / (12 * -11))) + 17) + 5
    = ((10 * (6 / -132)) + 17) + 5
    = ((10 * 0) + 17) + 5
    = (0 + 17) + 5
    = 17 + 5
    = 22
*/

import java.util.Stack;

public class Problem150 {
    public static void main(String[] args) {
        Solution150 solution = new Solution150();

        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(solution.evalRPN(tokens));
    }
}

class Solution150 {
    private static final String DIVISION = "/";
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";

    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();
        int first, second;

        for (String token : tokens) {
            if (DIVISION.equals(token)) {
                first = numbers.pop();
                second = numbers.pop();
                numbers.push(second / first);
            } else if (ADDITION.equals(token)) {
                numbers.push(numbers.pop() + numbers.pop());
            } else if (SUBTRACTION.equals(token)) {
                first = numbers.pop();
                second = numbers.pop();
                numbers.push(second - first);
            } else if (MULTIPLICATION.equals(token)) {
                numbers.push(numbers.pop() * numbers.pop());
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }

        return numbers.pop();
    }
}
