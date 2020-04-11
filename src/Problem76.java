/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

  Example:

    Input: S = "ADOBECODEBANC", T = "ABC"
    Output: "BANC"
    Note:

    If there is no such window in S that covers all characters in T, return the empty string "".
    If there is such window, you are guaranteed that there will always be only one unique minimum window in S.

    Note: use two pointers to gradually move along and form a window.
 */

import java.util.HashMap;
import java.util.Map;

public class Problem76 {
    public static void main(String[] args) {
        Solution76 solution = new Solution76();

        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }
}

class Solution76 {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> charactersInT = new HashMap<>();

        int left = 0, right = 0;

        for (int i = 0; i < t.length(); i++) {
            int count = charactersInT.getOrDefault(t.charAt(i), 0);
            charactersInT.put(t.charAt(i), count + 1);
        }

        int required = charactersInT.size(), actual = 0;
        Map<Character, Integer> countsInWindow = new HashMap<>();

        int[] output = {-1, 0, 0};

        while (right < s.length()) {
            char c = s.charAt(right);

            int count = countsInWindow.getOrDefault(c, 0);
            countsInWindow.put(c, count + 1);

            if (charactersInT.containsKey(c) && countsInWindow.get(c).intValue() == charactersInT.get(c).intValue()) {
                actual++;
            }

            while (left <= right && actual == required) {
                c = s.charAt(left);

                if (output[0] == -1 || right - left + 1 < output[0]) {
                    output[0] = right - left + 1;
                    output[1] = left;
                    output[2] = right;
                }

                countsInWindow.put(c, countsInWindow.get(c) - 1);

                if (charactersInT.containsKey(c) && countsInWindow.get(c).intValue() < charactersInT.get(c).intValue()) {
                    actual--;
                }

                left++;
            }

            right++;
        }

        return output[0] == -1 ? "" : s.substring(output[1], output[2] + 1);
    }
}
