package third;
/*
Given a undirected graph represented by an adjacency list adj, where each adj[i] represents the list of vertices connected to vertex i. Perform a Breadth First Search (BFS) traversal starting from vertex 0, visiting vertices from left to right according to the adjacency list, and return a list containing the BFS traversal of the graph.

Examples:

Input: adj[][] = [[1,2], [0,2,3], [0,1,4], [1,4], [2,3]]

Breadth-First-Search-or-BFS-for-a-Graph


Output: [0, 1, 2, 3, 4]
Explanation: Starting from 0, the BFS traversal will follow these steps:
Visit 0 → Output: [0]
Visit 1 (first neighbor of 0) → Output: [0, 1]
Visit 2 (next neighbor of 0) → Output: [0, 1, 2]
Visit 3 (next neighbor of 1) → Output: [0, 1, 2, 3]
Visit 4 (neighbor of 2) → Final Output: [0, 1, 2, 3, 4]
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class ProblemDSA45 {
    public static void main(String[] args) {
        SolutionDSA45 solution = new SolutionDSA45();
        List<List<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(0, 2, 3)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(1, 4)));
        adj.add(new ArrayList<>(Arrays.asList(2, 3)));

        System.out.println(solution.bfs(adj));
    }
}

class SolutionDSA45 {
    public List<Integer> bfs(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        dq.add(0);
        visited[0] = true;

        while (!dq.isEmpty()) {
            int curr = dq.pop();
            res.add(curr);
            for (int i : adj.get(curr)) {
                if (!visited[i]) {
                    dq.add(i);
                    visited[i] = true;
                }
            }
        }

        return res;
    }


}