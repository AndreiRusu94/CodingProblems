package third;
/*
Given a graph with V vertices numbered from 0 to V-1 and a list of edges, determine whether the graph is bipartite or not.

Note: A bipartite graph is a type of graph where the set of vertices can be divided into two disjoint sets, say U and V, such that every edge 
connects a vertex in U to a vertex in V, there are no edges between vertices within the same set.

Example:

Input: V = 4, edges[][]= [[0, 1], [0, 2], [1, 2], [2, 3]]
Output: false

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemDSA74 {
    public static void main(String[] args) {
        SolutionDSA74 solution = new SolutionDSA74();

        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        int v = 4;

        System.out.println(solution.isBipartite(edges, v));

        edges = new int[][]{{0, 1}, {1, 2}, {2, 3}};

        System.out.println(solution.isBipartite(edges, v));
    }
}

class SolutionDSA74 {

    public boolean isBipartite(int[][] edges, int v) {
        List<List<Integer>> adj = constructAdj(edges, v);
        int[] colors = new int[v];

        Arrays.fill(colors, -1);

        for (int i = 0; i < v; i++) {
            if (colors[i] == -1) {
                if (!dfs(adj, colors, i, 0)) {
                    return false;
                }
            }
        }

        return true;
    }

    private List<List<Integer>> constructAdj(int[][] edges, int v) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return adj;
    }

    private boolean dfs(List<List<Integer>> adj, int[] colors, int v, int color) {
        colors[v] = color;

        for (int u : adj.get(v)) {
            if (colors[u] == -1) {
                if (!dfs(adj, colors, u, 1 - color)) {
                    return false;
                }
            } else {
                if (colors[u] == colors[v]) {
                    return false;
                }
            }
        }

        return true;
    }

}

