package first;
/*
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem394 {
    public static void main(String[] args) {
        Solution394 solution = new Solution394();

        String input = "3[a]2[bc]";
        System.out.println(solution.decodeString(input));
    }
}

class Solution394 {
    public String decodeString(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == ']') {
                StringBuilder temp = new StringBuilder();
                StringBuilder output = new StringBuilder();

                while (stack.peek() != '[') {
                    temp.append(stack.pop());
                }

                stack.pop();
                StringBuilder sizeAsString = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    sizeAsString.insert(0, stack.pop());
                }

                temp.reverse();
                for (int i = 0; i < Integer.parseInt(sizeAsString.toString()); i++) {
                    output.append(temp);
                }

                for (int i = 0; i < output.length(); i++) {
                    stack.push(output.charAt(i));
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = stack.size() - 1; i >= 0; i--) {
            output.append(stack.pop());
        }

        return output.reverse().toString();
    }
}