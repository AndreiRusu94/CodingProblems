package third;
/*
Given n nodes of a forest (collection of trees), find the number of trees in the forest.

Examples : 

Input :  edges[] = {0, 1}, {0, 2}, {3, 4}
Output : 2
Explanation : There are 2 trees
                   0       3
                  / \       \
                 1   2       4

*/

import java.util.ArrayList;
import java.util.List;

public class ProblemDSA69 {
    public static void main(String[] args) {
        SolutionDSA69 solution = new SolutionDSA69();

        int[][] m = {{0, 1}, {0, 2}, {3, 4}};
        int v = 5;

        System.out.println(solution.countTrees(m, v));
    }
}

class SolutionDSA69 {

    public int countTrees(int[][] m, int v) {
        List<List<Integer>> adj = constructAdj(m, v);
        boolean[] visited = new boolean[v];
        int treeCount = 0;

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited);
                treeCount++;
            }
        }

        return treeCount;
    }

    private List<List<Integer>> constructAdj(int[][] m, int v) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : m) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        return adj;
    }

    private void dfs(List<List<Integer>> adj, int i, boolean[] visited) {
        visited[i] = true;

        for (int u : adj.get(i)) {
            if (!visited[u]) {
                dfs(adj, u, visited);
            }
        }
    }

}