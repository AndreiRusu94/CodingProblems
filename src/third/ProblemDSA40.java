package third;
/*
Given a string s containing three types of brackets {}, () and []. We have to determine whether the brackets arebalanced. An expression is balanced if each opening bracket has a corresponding closing bracket of the same type, the pairs are properly ordered and no bracket closes before its matching opening bracket.

Balanced:"[()()]{}" → every opening bracket is closed in the correct order.
Not balanced:"([{]})" → the ] closes before the matching { is closed, breaking the nesting rule.
Example: 

Input: s = "[{()}]"
Output: true
Explanation:  All the brackets are well-formed.

Input: s = "[()()]{}"
Output: true
Explanation: All the brackets are well-formed.

Input: s = "([]"
Output: false
Explanation: The expression is not balanced as there is a missing ')' at the end.

Input:  s = "([{]})"
Output: false
Explanation: The expression is not balanced because there is a closing ']' before the closing '}'.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemDSA40 {
    public static void main(String[] args) {
        SolutionDSA40 solution = new SolutionDSA40();

        System.out.println("Is balanced: " + solution.isBalanced("5 * (3 + [2 - {7 / (1 + 1)}])"));
    }
}

class SolutionDSA40 {
    public boolean isBalanced(String s) {
        Deque<Character> characters = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                characters.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                if (characters.isEmpty()) {
                    return false;
                }

                char top = characters.pop();
                if ((c == '}' && top != '{') ||
                        (c == ']' && top != '[') ||
                        (c == ')' && top != '(')) {
                    return false;
                }
            }
        }

        return characters.isEmpty();
    }


}