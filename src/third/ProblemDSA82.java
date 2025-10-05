package third;
/*
You are given n houses in a colony, numbered from 1 to n, and p pipes connecting these houses. Each house has at most one outgoing pipe and at
most one incoming pipe. Your goal is to install tanks and taps efficiently.

A tank is installed at a house that has one outgoing pipe but no incoming pipe.
A tap is installed at a house that has one incoming pipe but no outgoing pipe.
Each pipe is represented as (a[i], b[i], d[i]), where:

a[i] is the house where the pipe starts.
b[i] is the house where the pipe ends.
d[i] is the pipe's diameter.
The task is to determine all tank-tap pairs and the minimum pipe diameter in each connection.

Examples:

Input: n = 9, p = 6, a[] = [7, 5, 4, 2, 9, 3], b[] = [4, 9, 6, 8, 7, 1], d[] = [98, 72, 10, 22, 17, 66]
Output: [[2, 8, 22], [3, 1, 66], [5, 6, 10]]
Explanation: Identify Tanks and Taps:
Tanks (houses with outgoing pipes but no incoming pipes): 2, 3, 5
Taps (houses with incoming pipes but no outgoing pipes): 8, 1, 6

Find Tank-Tap Paths:
2 -> 8 (Min Diameter = 22) -> [2, 8, 22]
3 -> 1 (Min Diameter = 66) -> [3, 1, 66]
5 -> 9 -> 7 -> 4 -> 6 (Min Diameter = 10) -> [5, 6, 10]

Input: n = 4, p = 2, a[] = [1, 3], b[] = [2, 4], d[] = [60, 50]
Output: [[1, 2, 60], [3, 4, 50]]
Explanation: Identify Tanks and Taps:
Tanks (houses with outgoing pipes but no incoming pipes): 1, 3
Taps (houses with incoming pipes but no outgoing pipes): 2, 4

Find Tank-Tap Paths:
1 -> 2 (Min Diameter = 60) → [1, 2, 60]
3 -> 4 (Min Diameter = 50) → [3, 4, 50]
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemDSA82 {
    public static void main(String[] args) {
        SolutionDSA82 solution = new SolutionDSA82();

        int n = 9, p = 6;
        List<Integer> a = Arrays.asList(7, 5, 4, 2, 9, 3),
                b = Arrays.asList(4, 9, 6, 8, 7, 1),
                d = Arrays.asList(98, 72, 10, 22, 17, 66);

        List<List<Integer>> ans = solution.findWaterDistribution(n, p, a, b, d);
        System.out.println(ans);
    }
}

class SolutionDSA82 {

    public List<List<Integer>> findWaterDistribution(int n, int p, List<Integer> a, List<Integer> b, List<Integer> d) {
        int[] outgoing = new int[n + 1];
        int[] incoming = new int[n + 1];
        int[] diameter = new int[n + 1];

        Arrays.fill(outgoing, -1);
        Arrays.fill(incoming, -1);
        Arrays.fill(diameter, Integer.MAX_VALUE);

        for (int i = 0; i < p; i++) {
            outgoing[a.get(i)] = b.get(i);
            incoming[b.get(i)] = a.get(i);
            diameter[a.get(i)] = d.get(i);
        }

        List<List<Integer>> output = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (outgoing[i] != -1 && incoming[i] == -1) {
                int curr = i, minDia = Integer.MAX_VALUE;

                while (outgoing[curr] != -1) {
                    minDia = Math.min(minDia, diameter[curr]);
                    curr = outgoing[curr];
                }

                output.add(List.of(i, curr, minDia));
            }
        }

        return output;
    }
}

