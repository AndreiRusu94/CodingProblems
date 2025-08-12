package third;
/*
Given an array of strings, find if the given strings can be chained to form a circle. A string X can be put before another string Y in a circle if the last character of X is the same as the first character of Y.

Examples:

Input: arr[] = {"geek", "king"}
Output: Yes, the given strings can be chained.
Note that the last character of first string is same
as first character of second string and vice versa is
also true.

Input: arr[] = {"for", "geek", "rig", "kaf"}
Output: Yes, the given strings can be chained.
The strings can be chained as "for", "rig", "geek"
and "kaf"

Input: arr[] = {"aab", "bac", "aaa", "cda"}
Output: Yes, the given strings can be chained.
The strings can be chained as "aaa", "aab", "bac"
and "cda"

Input: arr[] = {"aaa", "bbb", "baa", "aab"};
Output: Yes, the given strings can be chained.
The strings can be chained as "aaa", "aab", "bbb"
and "baa"

Input: arr[] = {"aaa"};
Output: Yes

Input: arr[] = {"aaa", "bbb"};
Output: No

Input  : arr[] = ["abc", "efg", "cde", "ghi", "ija"]
Output : Yes
These strings can be reordered as, “abc”, “cde”, “efg”,
“ghi”, “ija”

Input : arr[] = [“ijk”, “kji”, “abc”, “cba”]
Output : No
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ProblemDSA38 {
    public static void main(String[] args) {
        SolutionDSA38 solution = new SolutionDSA38();

        System.out.println("Can be chained: " + solution.possibleOrderAmongString(new String[]{"ijk”, “kji”, “abc”, “cba"}));
    }
}

class SolutionDSA38 {
    public boolean possibleOrderAmongString(String[] s) {
        boolean[] marked = new boolean[26];
        int[] in = new int[26], out = new int[26];
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        for (String curr : s) {
            int first = curr.charAt(0) - 'a';
            int last = curr.charAt(curr.length() - 1) - 'a';

            marked[first] = marked[last] = true;
            in[last]++;
            out[first]++;

            adj.get(first).add(last);
        }

        for (int i = 0; i < 26; i++) {
            if (in[i] != out[i]) {
                return false;
            }
        }

        boolean[] visited = new boolean[26];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(s[0].charAt(0) - 'a');

        while (!dq.isEmpty()) {
            var num = dq.poll();
            visited[num] = true;

            for (var n : adj.get(num)) {
                if (!visited[n]) {
                    dq.push(n);
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (marked[i] && !visited[i]) {
                return false;
            }
        }

        return true;
    }


}