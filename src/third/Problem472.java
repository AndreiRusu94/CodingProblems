package third;
/*
Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words (not necessarily distinct) in the given array.

 

Example 1:

Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
Example 2:

Input: words = ["cat","dog","catdog"]
Output: ["catdog"]
 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem472 {
    public static void main(String[] args) {
        Solution472 solution = new Solution472();

        System.out.println(solution.findAllConcatenatedWordsInADict(new String[]{
                "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"
        }));
    }
}


class Solution472 {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> output = new ArrayList<>();
        Set<String> preWords = new HashSet<>();

        Arrays.sort(words, Comparator.comparingInt(String::length));

        for (String word : words) {
            if (canForm(word, preWords)) {
                output.add(word);
            }
            preWords.add(word);
        }

        return output;
    }

    private static boolean canForm(String word, Set<String> preWords) {
        if (preWords.isEmpty()) {
            return false;
        }

        boolean[] dp = new boolean[word.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= word.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (!dp[j]) {
                    continue;
                }

                if (preWords.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[word.length()];
    }
}


