package third;
/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem438 {
    public static void main(String[] args) {
        Solution438 solution = new Solution438();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
    }
}

class Solution438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> output = new ArrayList<>();
        if (s == null || s.length() < p.length()) {
            return output;
        }

        Map<Character, Integer> frequencies = new HashMap<>();
        int start = 0, end = 0;

        for (char c : p.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        int counter = frequencies.size();

        while (end < s.length()) {
            char c = s.charAt(end);
            if (frequencies.containsKey(c)) {
                frequencies.put(c, frequencies.get(c) - 1);
                if (frequencies.get(c) == 0) {
                    counter--;
                }
            }
            end++;

            while (counter == 0) {
                char tempC = s.charAt(start);
                if (frequencies.containsKey(tempC)) {
                    frequencies.put(tempC, frequencies.get(tempC) + 1);
                    if (frequencies.get(tempC) > 0) {
                        counter++;
                    }
                }

                if (end - start == p.length()) {
                    output.add(start);
                }

                start++;
            }
        }

        return output;
    }

}

