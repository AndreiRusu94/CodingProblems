package third;
/*
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible
sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []
 
*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Problem140 {
    public static void main(String[] args) {
        Solution140 solution = new Solution140();

        System.out.println(solution.wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple")));
    }
}


class Solution140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<>());
    }

    private List<String> DFS(String s, List<String> wordDict, Map<String, LinkedList<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }

        LinkedList<String> res = new LinkedList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> subList = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : subList) {
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }

        map.put(s, res);
        return res;
    }
}


