package third;
/*
Shortest path in a Binary Maze

Given an M x N matrix where each element can either be 0 or 1. We need to find the shortest path between a given source cell to a destination cell.
The path can only be created out of a cell if its value is 1.

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

public class ProblemDSA59 {
    public static void main(String[] args) {
        SolutionDSA59 solution = new SolutionDSA59();

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

        System.out.println(solution.DFS(mat, solution.new Point(0, 0), solution.new Point(3, 4)));
    }
}

class SolutionDSA59 {

    public class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private class Node {
        Point p;
        int d;

        public Node(Point p, int d) {
            this.p = p;
            this.d = d;
        }
    }

    public int DFS(int[][] mat, Point src, Point dest) {
        if (mat[dest.x][dest.y] == 0 || mat[src.x][src.y] == 0) {
            return -1;
        }

        int r = mat.length;
        int c = mat[0].length;

        boolean[][] visited = new boolean[r][c];
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(src, 0));
        visited[src.x][src.y] = true;

        while (!dq.isEmpty()) {
            Node current = dq.pop();
            int d = current.d;
            Point p = current.p;

            if (p.x == dest.x && p.y == dest.y) {
                return d;
            }

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int newX = p.x + dx[i];
                int newY = p.y + dy[i];

                if (isValid(newX, newY, r, c) && mat[newX][newY] == 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    dq.add(new Node(new Point(newX, newY), d + 1));
                }
            }

        }

        return -1;

    }

    private boolean isValid(int x, int y, int r, int c) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

}