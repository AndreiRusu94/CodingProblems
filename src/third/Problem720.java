package third;
/*
Given an array of strings words representing an English Dictionary, return the longest word in words that can be built one character at a time by other words in words.

If there is more than one possible answer, return the longest word with the smallest lexicographical order. If there is no answer, return the empty string.

Note that the word should be built from left to right with each additional character being added to the end of a previous word.

Example 1:

Input: words = ["w","wo","wor","worl","world"]
Output: "world"
Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:

Input: words = ["a","banana","app","appl","ap","apply","apple"]
Output: "apple"
Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".

*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem720 {
    public static void main(String[] args) {
        Solution720 solution = new Solution720();

        System.out.println(solution.longestWord(new String[]{"w", "wo", "wor", "worl", "world"}));
    }
}

class Solution720 {

    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> prefix = new HashSet<>();
        String output = "";

        for (String word : words) {
            if (word.length() == 1 || prefix.contains(word.substring(0, word.length() - 1))) {
                output = word.length() > output.length() ? word : output;
                prefix.add(word);
            }
        }

        return output;
    }

}

