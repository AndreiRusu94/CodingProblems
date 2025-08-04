package third;
/*
An encoded string s is given, the task is to decode it. See examples to understand the pattern in which string is encoded .

Examples:

Input: s = "3[b2[ca]]"
Output: "bcacabcacabcaca"
Explanation:  1. inner substring "2[ca]" breakdown into "caca".
                         2. now , new string becomes "3[bcaca]"
                         3. similarly "3[bcaca]" becomes "bcacabcacabcaca " which is final result.

Input: s = "2[ab]"
Output: "abab"

Input: s = "2[ab]a"
Output: "ababa"
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemDSA21 {
    public static void main(String[] args) {
        SolutionDSA21 solution = new SolutionDSA21();

        System.out.println(solution.decodeString("3[b2[ca]]"));
    }
}

class SolutionDSA21 {

    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder temp = new StringBuilder();

                while (!stack.isEmpty() && stack.peek() != '[') {
                    temp.append(stack.pop());
                }
                temp.reverse();
                stack.pop();

                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num.insert(0, stack.pop());
                }

                int number = Integer.parseInt(num.toString());
                StringBuilder repeat = new StringBuilder();

                for (int i = 0; i < number; i++) {
                    repeat.append(temp);
                }

                for (char e : repeat.toString().toCharArray()) {
                    stack.push(e);
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder output = new StringBuilder();
        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        output.reverse();
        return output.toString();
    }

}
