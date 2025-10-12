package third;
/*
Given an undirected graph, the task is to determine whether the graph contains a Hamiltonian cycle or not. If it contains, then print the path.

Examples:

Input: graph[][] = [[0, 1, 0, 1, 0], [1, 0, 1, 1, 1], [0, 1, 0, 0, 1], [1, 1, 0, 0, 1], [0, 1, 1, 1, 0]]

Input graph[][]
Output: 0 1 2 4 3 0

*/

import java.util.Arrays;

public class ProblemDSA96 {
    public static void main(String[] args) {
        SolutionDSA96 solution = new SolutionDSA96();

        int[][] graph = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };

        int[] path = solution.hamCycle(graph);
        System.out.println(Arrays.toString(path));
    }
}

class SolutionDSA96 {

    public int[] hamCycle(int[][] graph) {
        int n = graph.length;
        int[] path = new int[n + 1];
        Arrays.fill(path, -1);
        path[0] = 0;

        if (!hamCycleUtil(graph, path, 1, n)) {
            return new int[]{-1};
        }

        path[n] = 0;

        return path;
    }

    private boolean hamCycleUtil(int[][] graph, int[] path, int pos, int n) {
        if (pos == n) {
            return graph[path[pos - 1]][path[0]] == 1;
        }

        for (int v = 1; v < n; v++) {
            if (isValid(graph, path, pos, v)) {
                path[pos] = v;
                if (hamCycleUtil(graph, path, pos + 1, n)) {
                    return true;
                }

                path[pos] = -1;
            }
        }

        return false;
    }

    private boolean isValid(int[][] graph, int[] path, int pos, int v) {
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }

        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }

        return true;
    }

}

