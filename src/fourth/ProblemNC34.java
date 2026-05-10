package fourth;
/*
You are given a 2-D matrix grid. Each cell can have one of three possible values:

0 representing an empty cell
1 representing a fresh fruit
2 representing a rotten fruit
Every minute, if a fresh fruit is horizontally or vertically adjacent to a rotten fruit, then the fresh fruit also becomes rotten.

Return the minimum number of minutes that must elapse until there are zero fresh fruits remaining. If this state is impossible within the grid, return -1.

Example 1:
Input: grid = [[1,1,0],[0,1,1],[0,1,2]]

Output: 4

Time complexity: O(m * n)
Space complexity: O(m * n)

*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemNC34 {
    public static void main(String[] args) {
        SolutionNC34 solution = new SolutionNC34();

        int[][] grid = {
                {1, 1, 0},
                {0, 1, 1},
                {0, 1, 2}
        };
        System.out.println(solution.orangesRotting(grid));
    }

}

class SolutionNC34 {

    public int orangesRotting(int[][] grid) {
        Deque<int[]> dq = new ArrayDeque<>();
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }

                if (grid[i][j] == 2) {
                    dq.offer(new int[]{i, j});
                }
            }
        }

        int time = 0;

        while (fresh > 0 && !dq.isEmpty()) {
            int size = dq.size();

            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                int r = curr[0], c = curr[1];

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == 1) {
                        dq.offer(new int[]{nr, nc});
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }

            time++;
        }

        return fresh == 0 ? time : -1;
    }
}