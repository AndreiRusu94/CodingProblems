package third;
/*
Given a string str consisting of opening and closing parenthesis '(' and ')', the task is to find the length of the longest valid parenthesis substring.

Examples:

Input: str = "((()"
Output: 2
Explanation: Longest Valid Parentheses Substring is "()".

Input: str = ")()())"
Output: 4
Explanation: Longest Valid Parentheses Substring is "()()".
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemDSA44 {
    public static void main(String[] args) {
        SolutionDSA44 solution = new SolutionDSA44();

        System.out.println(solution.maxLength(")()())"));
    }
}

class SolutionDSA44 {
    public int maxLength(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxLength = 0;

        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }


}