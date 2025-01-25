package second;

/*
Given an array of strings strs, group the
anagrams together. You can return the answer in any order.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]
 */

import java.util.*;

public class Problem49 {

    public static void main(String[] args) {
        Solution49 solution = new Solution49();
        System.out.println("Grouped anagrams: " + solution.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupsOfAnagrams = new HashMap<>();

        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            groupsOfAnagrams.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(groupsOfAnagrams.values());
    }
}
