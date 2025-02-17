package second;
/*
A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string startGene to a gene string endGene where one mutation is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it a valid gene string.

Given the two gene strings startGene and endGene and the gene bank bank, return the minimum number of mutations needed to mutate from startGene to endGene. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

Example 1:

Input: startGene = "AACCGGTT", endGene = "AACCGGTA", bank = ["AACCGGTA"]
Output: 1
Example 2:

Input: startGene = "AACCGGTT", endGene = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA","AAACGGTA"]
Output: 2
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problem433 {
    public static void main(String[] args) {
        Solution433 solution = new Solution433();

        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }
}

class Solution433 {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, Integer> distance = new HashMap<>();
        Queue<String> q = new LinkedList<>();

        distance.put(startGene, 0);
        q.offer(startGene);

        while (!q.isEmpty()) {
            var u = q.poll();

            for (String v : bank) {
                if (distance.get(v) != null) {
                    continue;
                }

                int count = 0;
                for (int i = 0; i < 8; i++) {
                    if (u.charAt(i) != v.charAt(i)) {
                        count++;
                    }
                }

                if (count == 1) {
                    distance.put(v, distance.get(u) + 1);
                    q.offer(v);
                }
            }
        }

        if (distance.get(endGene) != null) {
            return distance.get(endGene);
        }

        return -1;
    }
}