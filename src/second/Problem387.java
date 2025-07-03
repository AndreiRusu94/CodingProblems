package second;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"

Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"

Output: 2

Example 3:

Input: s = "aabb"

Output: -1
 */

import java.util.HashMap;
import java.util.Map;

public class Problem387 {
    public static void main(String[] args) {
        Solution387 solution = new Solution387();
        System.out.println(solution.firstUniqChar("leetcode"));
    }
}

class Solution387 {
    public int firstUniqChar(String s) {
        int count[] = new int[26];
        char[] chars = s.toCharArray();
        Map<Integer, Integer> charToIndex = new HashMap<>();

        for (int i = 0; i < chars.length; i++) {
            count[chars[i] - 'a']++;
            charToIndex.put(chars[i] - 'a', i);
        }

        for (int i = 0; i < chars.length; i++) {
            if (count[chars[i] - 'a'] == 1) {
                return charToIndex.get(chars[i] - 'a');
            }
        }

        return -1;
    }
}