package third;
/*
Given a 2D grid of size n*n, where each cell represents the cost to traverse through that cell, the task is to find the minimum cost to move from
the top left cell to the bottom right cell. From a given cell, we can move in 4 directions: left, right, up, down.

Note: It is assumed that negative cost cycles do not exist in input matrix.

Example:

Input: grid = {{9, 4, 9, 9},
                        {6, 7, 6, 4},
                       {8, 3, 3, 7},
                      {7, 4, 9, 10}}
Output: 43
Explanation: The minimum cost path is 9 + 4 + 7 + 3 + 3 + 7 + 10.

*/

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ProblemDSA66 {
    public static void main(String[] args) {
        SolutionDSA66 solution = new SolutionDSA66();

        int[][] grid = {
                {9, 4, 9, 9},
                {6, 7, 6, 4},
                {8, 3, 3, 7},
                {7, 4, 9, 10}
        };

        System.out.println(solution.minimumCostPath(grid));
    }
}

class SolutionDSA66 {

    public int minimumCostPath(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int n = grid.length;
        int m = grid[0].length;
        int[][] cost = new int[n][m];

        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.add(new int[]{grid[0][0], 0, 0});
        cost[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

            for (int[] dir : dirs) {
                int x = curr[1] + dir[0];
                int y = curr[2] + dir[1];
                if (isValidCell(x, y, n) && cost[x][y] > cost[curr[1]][curr[2]] + grid[x][y]) {
                    cost[x][y] = cost[curr[1]][curr[2]] + grid[x][y];
                    pq.add(new int[]{cost[x][y], x, y});
                }
            }
        }

        return cost[n - 1][m - 1];
    }

    private boolean isValidCell(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

}