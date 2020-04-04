/*
Given an array of strings, group anagrams together.

  Example:

    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
    Output:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]

  Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
 */


import java.util.*;

public class Problem49 {
    public static void main(String[] args) {
        Solution49 solution = new Solution49();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(solution.groupAnagrams(strs));
    }
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortedToActual = new HashMap<>();
        for(String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);

            String key = String.valueOf(chars);

            sortedToActual.computeIfAbsent(key, k -> new ArrayList<>());
            sortedToActual.get(key).add(s);
        }

        return new ArrayList<>(sortedToActual.values());
    }
}