package third;
/*
Eulerian path and circuit for undirected graph

Given an undirected connected graph with v nodes, and e edges, with adjacency list adj. We need to write a function that returns 2 if the graph
contains an eulerian circuit or cycle, else if the graph contains an eulerian path, returns 1, otherwise, returns 0.

A graph is said to be Eulerian if it contains an Eulerian Cycle, a cycle that visits every edge exactly once and starts and ends at the same vertex.
If a graph contains an Eulerian Path, a path that visits every edge exactly once but starts and ends at different vertices, it is called
Semi-Eulerian.

Time Complexity: O(v + e), DFS traverses all vertices and edges to check connectivity and degree.
Space Complexity: O(v + e), Space used for visited array and adjacency list to represent graph.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProblemDSA72 {
    public static void main(String[] args) {
        SolutionDSA72 solution = new SolutionDSA72();

        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 0}, {1, 2}, {2, 1}, {2, 0}, {3, 0}, {3, 4}, {4, 3}};
        int v = 5;

        System.out.println(solution.isEulerianCycle(edges, v));
    }
}

class SolutionDSA72 {

    public int isEulerianCycle(int[][] edges, int v) {
        List<List<Integer>> adj = constructAdj(edges, v);

        int start = -1;
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!adj.get(i).isEmpty()) {
                start = i;
                break;
            }
        }

        if (start == -1) {
            return -2;
        }

        dfs(visited, adj, start);

        for (int i = 0; i < v; i++) {
            if (!adj.get(i).isEmpty() && !visited[i]) {
                return 0;
            }
        }

        int odd = 0;
        for (int i = 0; i < v; i++) {
            if (adj.get(i).size() % 2 == 1) {
                odd++;
            }
        }

        if (odd == 0) {
            return 2;
        } else if (odd == 2) {
            return 1;
        }

        return 0;
    }

    private List<List<Integer>> constructAdj(int[][] edges, int v) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        return adj;
    }

    private void dfs(boolean[] visited, List<List<Integer>> adj, int v) {
        visited[v] = true;

        for (int neighbour : adj.get(v)) {
            if (!visited[neighbour]) {
                dfs(visited, adj, neighbour);
            }
        }
    }

}

