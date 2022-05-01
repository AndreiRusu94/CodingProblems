package first;
/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

import java.util.ArrayList;
import java.util.List;

public class Problem22 {
    public static void main(String[] args) {
        Solution22 solution = new Solution22();

        int input = 3;
        System.out.println(solution.generateParenthesis(input));
    }
}

class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();

        generateSolution("", output, 0, 0, n);

        return output;
    }

    public void generateSolution(String current, List<String> output, int open, int close, int maxLength) {
        if (current.length() == maxLength * 2) {
            output.add(current);
            return;
        }

        if (open < maxLength) {
            generateSolution(current + "(", output, open+1, close, maxLength);
        }

        if (close < open) {
            generateSolution(current + ")", output, open, close+1, maxLength);
        }
    }
}