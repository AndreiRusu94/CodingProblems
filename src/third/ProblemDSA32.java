package third;

/*
Given an M x N matrix where each element can either be 0 or 1. We need to find the shortest path between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1.

Note: You can move into an adjacent cell in one of the four directions, Up, Down, Left, and Right if that adjacent cell is filled with element 1.

Example:

Input: mat[][] = [[1, 1, 1, 1], [1, 1, 0, 1], [1, 1, 1, 1], [1, 1, 0, 0], [1, 0, 0, 1]], source = [0, 1], destination = {2, 2}
Output: 3
Explanation: The path is (0, 1) -> (1, 1) -> (2, 1) - > (2, 2) (the same is highlighted below)
1 1 1 1
1 1 0 1
1 1 1 1
1 1 0 0
1 0 0 1

Input: mat[][] = [[1, 1, 1, 1, 1], [1, 1, 1, 1, 1], [1, 1, 1, 1, 0 ] , [1, 0, 1, 0, 1]], source = {0, 0}, destination = {3, 4}
Output: -1
Explanation: The path is not possible between source and destination, hence return -1.
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ProblemDSA32 {

    public static void main(String[] args) {
        SolutionDSA32 solution = new SolutionDSA32();
        int[][] mat = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 0, 0, 0, 0, 1, 0, 0, 1}
        };

        System.out.println(solution.bfs(mat, solution.new Point(0, 0, 0), solution.new Point(3, 4, 0)));
    }
}

class SolutionDSA32 {

    public class Point {
        int x, y, d;
        public Point(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public int bfs(int[][] matrix, Point src, Point dest) {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

        // invalid source or destination
        if (matrix[src.x][src.y] == 0 || matrix[dest.x][dest.y] == 0) {
            return -1;
        }

        Deque<Point> dq = new ArrayDeque<>();
        dq.add(src);
        matrix[src.x][src.y] = 3;

        while (!dq.isEmpty()) {
            Point curr = dq.poll();
            int x = curr.x;
            int y = curr.y;

            // explore all possible directions
            for (int[] dir : directions) {
                int newX = dir[0] + x;
                int newY = dir[1] + y;

                if (newX < 0 || newX >= matrix.length || newY < 0 || newY >= matrix[0].length) {
                    continue;
                }

                // reached destination
                if (newX == dest.x && newY == dest.y) {
                    return curr.d + 1;
                }

                if (matrix[newX][newY] == 1) {
                    dq.add(new Point(newX, newY, curr.d + 1));
                    matrix[newX][newY] = 3;
                }
            }
        }

        return -1;

    }

}