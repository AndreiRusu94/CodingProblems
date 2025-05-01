package second;
/*
Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

Constraints:

1 <= s.length <= 105
s[i] is either '(' , ')', or lowercase English letter.
 */


import java.util.ArrayDeque;
import java.util.Deque;

public class Problem1249 {
    public static void main(String[] args) {
        Solution1249 solution = new Solution1249();

        System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));
    }
}

class Solution1249 {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        boolean[] b = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) {
                    b[i] = true;
                    b[stack.pop()] = true;
                }
            } else {
                b[i] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (b[i]) {
                output.append(s.charAt(i));
            }
        }

        return output.toString();
    }
}
