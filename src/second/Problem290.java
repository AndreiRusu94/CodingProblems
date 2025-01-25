package second;

/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.

Example 1:

Input: pattern = "abba", s = "dog cat cat dog"

Output: true

Explanation:

The bijection can be established as:

'a' maps to "dog".
'b' maps to "cat".
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"

Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"

Output: false

Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
 */

import java.util.HashMap;
import java.util.Map;

public class Problem290 {

    public static void main(String[] args) {
        Solution290 solution = new Solution290();
        System.out.println("Words match pattern: " + solution.wordPattern("abba", "dog cat cat fish"));
    }
}

class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }

        Map<Character, String> patternToWord = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            var word = patternToWord.get(pattern.charAt(i));
            if (word != null) {
                if (!word.equals(words[i])) {
                    return false;
                }
            } else if (patternToWord.containsValue(words[i])) {
                return false;
            }
            patternToWord.put(pattern.charAt(i), words[i]);
        }

        return true;
    }
}
