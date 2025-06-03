package second;
/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
*/

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem994 {
    public static void main(String[] args) {
        Solution994 solution = new Solution994();

        System.out.println(solution.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}

class Solution994 {

    public int orangesRotting(int[][] grid) {
        int minutes = -1, x, y;
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    minutes = 0;
                }
            }
        }

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean newlyRotten = false;
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();

                for (int[] direction : directions) {
                    x = rotten[0] + direction[0];
                    y = rotten[1] + direction[1];

                    if (x < 0 || x >= rows || y < 0 || y >= columns) {
                        continue;
                    }

                    if (grid[x][y] == 2 || grid[x][y] == 3 || grid[x][y] == 0) {
                        continue;
                    }

                    grid[x][y] = 3;
                    if (!newlyRotten) {
                        minutes++;
                        newlyRotten = true;
                    }
                    queue.offer(new int[]{x, y});
                }
            }
        }

        boolean rotten = false;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
                if (grid[i][j] == 2) {
                    rotten = true;
                }
            }
        }

        return rotten ? minutes : 0;
    }
}


