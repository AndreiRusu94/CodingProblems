package fourth;
/*
Count the unique paths from the top left to the bottom right. A single path may only move along 0's and can't visit the same cell more than once.

Complexity:
Time: O(4^(m*n)) in the worst case when all cells are 0's, as each cell can lead to 4 possible directions (up, down, left, right).
Space: O(m*n) in the worst case due to the recursion stack when all cells are 0's, as we may need to explore all cells in the grid.

*/

public class ProblemNC29 {
    public static void main(String[] args) {
        SolutionNC29 solution = new SolutionNC29();

        int[][] grid = {{0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0}};

        System.out.println(solution.countUnique(grid));
    }

}

class SolutionNC29 {
    public int countUnique(int[][] grid) {
        return dfs(grid, 0, 0, new int[grid.length][grid[0].length]);
    }

    private int dfs(int[][] grid, int i, int j, int[][] visited) {
        int n = grid.length, m = grid[0].length;
        if (!isValid(grid, visited, i, j, n, m)) {
            return 0;
        }

        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        visited[i][j] = 1;
        int count = 0;
        count += dfs(grid, i + 1, j, visited);
        count += dfs(grid, i, j + 1, visited);
        count += dfs(grid, i - 1, j, visited);
        count += dfs(grid, i, j - 1, visited);

        visited[i][j] = 0;
        return count;


    }

    private boolean isValid(int[][] grid, int[][] visited, int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m && grid[i][j] != 1 && visited[i][j] != 1;
    }
}