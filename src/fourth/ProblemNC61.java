package fourth;
/*
Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: strs = ["act","pots","tops","cat","stop","hat"]

Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
Example 2:

Input: strs = ["x"]

Output: [["x"]]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemNC61 {
    public static void main(String[] args) {
        SolutionNC61 solution = new SolutionNC61();
        System.out.println(solution.groupAnagrams(new String[]{"act", "pots", "tops", "cat", "stop", "hat"}));
    }
}

class SolutionNC61 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hashToElements = new HashMap<>();

        for (String s : strs) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String key = Arrays.toString(count);
            hashToElements.putIfAbsent(key, new ArrayList<>());
            hashToElements.get(key).add(s);
        }

        return new ArrayList<>(hashToElements.values());
    }

}

