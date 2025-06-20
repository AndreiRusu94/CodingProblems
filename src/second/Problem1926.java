package second;
/*
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.

Example 1:


Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.
*/


import java.util.LinkedList;
import java.util.Queue;

public class Problem1926 {
    public static void main(String[] args) {
        Solution1926 solution = new Solution1926();

        System.out.println(solution.nearestExit(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2}));
    }
}

class Solution1926 {

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> queue = new LinkedList<>();
        int rows = maze.length;
        int columns = maze[0].length;

        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int steps = 0, x, y;

        while (!queue.isEmpty()) {
            steps++;

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();

                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    if (x < 0 || x >= rows || y < 0 || y >= columns) {
                        continue;
                    }

                    if (maze[x][y] == '+') {
                        continue;
                    }

                    if (x == 0 || x == rows - 1 || y == 0 || y == columns - 1) {
                        return steps;
                    }

                    maze[x][y] = '+';
                    queue.offer(new int[]{x, y});
                }
            }
        }

        return -1;
    }
}


