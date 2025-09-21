package third;
/*
Given an array of strings arr[], and two different strings start and target, representing two words. The task is to find the length of the
smallest chain from string start to target, such that only one character of the adjacent words differs and each word exists in arr[].

Note: Print 0 if it is not possible to form a chain. Each word in array arr[] is of same size m and contains only lowercase English alphabets.

Examples:

Input: start = "toon", target = "plea", arr[] = ["poon", "plee", "same", "poie", "plea", "plie", "poin"]
Output: 7
Explanation: toon  → poon  → poin  → poie  → plie  → plee  → plea

Input: start = "abcv", target = "ebad", arr[] = ["abcd", "ebad", "ebcd", "xyza"]
Output: 4
Explanation: abcv  → abcd  → ebcd  → ebad



*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ProblemDSA61 {
    public static void main(String[] args) {
        SolutionDSA61 solution = new SolutionDSA61();

        String[] words = new String[]{"poon", "plee", "same", "poie", "plea", "plie", "poin"};

        System.out.println(solution.lengthOfSmallestChain(words, "toon", "plea"));
    }
}

class SolutionDSA61 {

    public int lengthOfSmallestChain(String[] words, String start, String target) {
        Set<String> visited = new HashSet<>();
        Deque<String> dq = new ArrayDeque<>();

        visited.add(start);
        dq.add(start);
        int output = 0;

        while (!dq.isEmpty()) {
            int size = dq.size();
            output++;

            for (int i = 0; i < size; i++) {
                String curr = dq.poll();

                for (String s : words) {
                    if (!visited.contains(s) && differsByOneChar(s, curr)) {
                        if (curr.equals(target)) {
                            return output;
                        }
                        dq.add(s);
                    }
                }
            }
        }

        return 0;
    }

    private boolean differsByOneChar(String x, String y) {
        int diffs = 0;

        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                diffs++;
            }

            if (diffs > 1) {
                return false;
            }
        }

        return diffs == 1;
    }

}