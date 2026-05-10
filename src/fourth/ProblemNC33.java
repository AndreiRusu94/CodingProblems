package fourth;
/*
You are given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

Example 1:

Input: grid = [
    [0,1,0],
    [1,0,0],
    [1,1,0]
]

Output: 3

Time complexity: O(m * n)
Space complexity: O(m * n)

*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemNC33 {
    public static void main(String[] args) {
        SolutionNC33 solution = new SolutionNC33();

        int[][] grid = {
                {0, 1, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 0, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(solution.shortestPathBinaryMatrix(grid));
    }

}

class SolutionNC33 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0, 1});

        int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 0}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}};

        boolean[][] visit = new boolean[n][n];
        visit[0][0] = true;

        while (!dq.isEmpty()) {
            int[] cell = dq.poll();
            int r = cell[0];
            int c = cell[1];
            int length = cell[2];

            if (r == n - 1 && c == n - 1) {
                return length;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && !visit[nr][nc]) {
                    dq.offer(new int[]{nr, nc, length + 1});
                    visit[nr][nc] = true;
                }
            }
        }

        return -1;
    }
}