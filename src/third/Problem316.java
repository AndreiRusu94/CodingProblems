package third;
/*
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among 
all possible results.

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
 

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

*/

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem316 {
    public static void main(String[] args) {
        Solution316 solution = new Solution316();

        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
    }
}

class Solution316 {

    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        boolean[] used = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = c - 'a';

            if (used[idx]) continue;

            while (!stack.isEmpty()
                    && stack.peek() > c
                    && last[stack.peek() - 'a'] > i) {
                used[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            used[idx] = true;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) res.append(stack.removeLast());
        return res.toString();
    }

}

