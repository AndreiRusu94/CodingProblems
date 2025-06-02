package second;
/*
There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.

Example 1:

Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
Example 2:


Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).
*/

import java.util.ArrayList;
import java.util.List;

public class Problem1466 {
    public static void main(String[] args) {
        Solution1466 solution = new Solution1466();
        int[][] isConnected = new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};

        System.out.println(solution.minReorder(6, isConnected));
    }
}

class Solution1466 {
    public int minReorder(int n, int[][] connections) {
        boolean[] visited = new boolean[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (var c : connections) {
            graph.get(c[0]).add(c[1]);
            graph.get(c[1]).add(-c[0]);
        }

        return dfs(graph, visited, 0);
    }

    private int dfs(List<List<Integer>> graph, boolean[] visited, int from) {
        int changes = 0;
        visited[from] = true;

        for (var to : graph.get(from)) {
            if (!visited[Math.abs(to)]) {
                changes += dfs(graph, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }

        return changes;
    }
}


