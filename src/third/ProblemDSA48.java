package third;
/*
Given a string str, the task is to find the substring of length K which occurs the maximum number of times. If more than one string occurs maximum number of times, then print the lexicographically smallest substring.

Examples:

Input: str = "bbbbbaaaaabbabababa", K = 5
Output: ababa
Explanation:
The substrings of length 5 from the above strings are {bbbbb, bbbba, bbbaa, bbaaa, baaaa, aaaaa, aaaab, aaabb, aabba, abbab, bbaba, babab, ababa, babab, ababa}.
Among all of them, substrings {ababa, babab} occurs the maximum number of times(= 2).
The lexicographically smallest string from {ababa, babab} is ababa.
Therefore, "ababa" is the required answer.

Input:  str = "heisagoodboy", K = 5
Output: agood
Explanation:
The substrings of length 5 from the above string are {heisa, eisag, isago, sagoo, agood, goodb, oodbo, odboy}.
All of them occur only once. But the lexicographically smallest string among them is "agood".
Therefore, "agood" is the required answer.
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProblemDSA48 {
    public static void main(String[] args) {
        SolutionDSA48 solution = new SolutionDSA48();

        System.out.println(solution.maximumOccurringString("heisagoodboy", 5));
    }
}

class SolutionDSA48 {
    public String maximumOccurringString(String s, int k) {
        Map<String, Integer> stringFrequency = new HashMap<>();
        Deque<Character> currWindow = new ArrayDeque<>();

        for (int i = 0; i < k; i++) {
            currWindow.addLast(s.charAt(i));
        }

        stringFrequency.put(currWindow.toString(), 1);

        for (int i = k; i < s.length(); i++) {
            currWindow.removeFirst();
            currWindow.addLast(s.charAt(i));
            stringFrequency.put(currWindow.toString(), stringFrequency.getOrDefault(currWindow.toString(), 0) + 1);
        }

        int maxFreq = 0;
        String output = "";

        for (String str : stringFrequency.keySet()) {
            if (stringFrequency.get(str) >= maxFreq) {
                maxFreq = Math.max(maxFreq, stringFrequency.get(str));
                if (output.isEmpty()) {
                    output = str;
                }
                output = str.compareTo(output) <= 0 ? str : output;
            }
        }

        return output;
    }


}