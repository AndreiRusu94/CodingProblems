package third;
/*
Kahn's Algorithm: Topological Sort
Given the number of vertices V and a list of directed edges, determine whether the graph contains a cycle or not.

Examples:

Input:  V = 4, edges[][] = [[0, 1], [1, 2], [2, 0], [2, 3]]

1

Output:  true
Explanation:  The diagram clearly shows a cycle 0 → 2 → 0

*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ProblemDSA62 {
    public static void main(String[] args) {
        SolutionDSA62 solution = new SolutionDSA62();

        int v = 4;
        int[][] edges = {
                {0, 1}, {0, 2}, {1, 2}, {2, 3}
        };

        System.out.println(solution.isCyclic(v, edges));
    }
}

class SolutionDSA62 {

    public boolean isCyclic(int v, int[][] edges) {
        List<List<Integer>> adj = constructAdj(v, edges);
        int[] inDegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (int u : adj.get(i)) {
                inDegree[u]++;
            }
        }

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < v; i++) {
            if (inDegree[i] == 0) {
                dq.add(i);
            }
        }

        int visited = 0;
        while (!dq.isEmpty()) {
            visited++;
            int u = dq.poll();

            for (int i : adj.get(u)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    dq.add(i);
                }
            }

        }

        return visited != v;
    }

    private List<List<Integer>> constructAdj(int v, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        return adj;
    }

}