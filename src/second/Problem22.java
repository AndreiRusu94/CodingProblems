package second;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 */

import java.util.ArrayList;
import java.util.List;

public class Problem22 {

    public static void main(String[] args) {
        Solution22 solution = new Solution22();
        System.out.println(solution.generateParenthesis(4));
    }
}

class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();

        backtrack(output, 0, 0, "", n);

        return output;
    }

    private void backtrack(List<String> output, int left, int right, String current, int n) {
        if (current.length() == n * 2) {
            output.add(current);
        }

        if (left < n) {
            backtrack(output, left + 1, right, current + "(", n);
        }

        if (right < left) {
            backtrack(output, left, right + 1, current + ")", n);
        }
    }
}
