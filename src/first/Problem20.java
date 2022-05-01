package first;
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

  Example 1:
    Input: "()"
    Output: true

  Example 2:
    Input: "()[]{}"
    Output: true
 */

import java.util.*;

public class Problem20 {
    public static void main(String[] args) {
        Solution20 solution = new Solution20();

        String input = "(((())))()";
        System.out.println(solution.isValid(input));
    }
}

class Solution20 {
    public HashMap<Character, Character> bracketsMapping;

    public Solution20() {
        this.bracketsMapping = new HashMap<>();
        this.bracketsMapping.put(')', '(');
        this.bracketsMapping.put(']', '[');
        this.bracketsMapping.put('}', '{');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (bracketsMapping.containsKey(c)) {
                char topElement = stack.isEmpty() ? '~' : stack.pop();

                if (topElement != bracketsMapping.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}