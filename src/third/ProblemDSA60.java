package third;
/*
Number of Islands
Last Updated : 23 Jul, 2025
Given an n x m grid of 'W' (Water) and 'L' (Land), the task is to count the number of islands. An island is a group of adjacent 'L' cells connected horizontally, vertically, or diagonally, and it is surrounded by water or the grid boundary. The goal is to determine how many distinct islands exist in the grid.

Examples:

Input: grid[][] = [['L', 'L', 'W', 'W', 'W'],
                            ['W', 'L', 'W', 'W', 'L'],
                          ['L', 'W', 'W', 'L', 'L'],
                         ['W', 'W', 'W', 'W', 'W'],
                        ['L', 'W', 'L', 'L', 'W']]
Output: 4

*/

public class ProblemDSA60 {
    public static void main(String[] args) {
        SolutionDSA60 solution = new SolutionDSA60();

        char[][] grid = {
                { 'L', 'L', 'W', 'W', 'W' },
                { 'W', 'L', 'W', 'W', 'L' },
                { 'L', 'W', 'W', 'L', 'L' },
                { 'W', 'W', 'W', 'W', 'W' },
                { 'L', 'W', 'L', 'L', 'W' }
        };

        System.out.println(solution.countNoIslands(grid));
    }
}

class SolutionDSA60 {

    public int countNoIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, boolean[][] visited, int x, int y) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int newX = dx[i] + x;
            int newY = dy[i] + y;

            if (isValid(grid, visited, newX, newY)) {
                dfs(grid, visited, newX, newY);
            }
        }
    }

    private boolean isValid(char[][] grid, boolean[][] visited, int x, int y) {
        int n = grid.length;
        int m = grid[0].length;

        return x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 'L' && !visited[x][y];
    }

}