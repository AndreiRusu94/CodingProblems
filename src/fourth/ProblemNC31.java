package fourth;
/*
Given a 2D grid 'grid' where '1' represents land and '0' represents water, count and return the number of islands.

An island is formed by connecting adjacent lands horizontally or vertically and is surrounded by water. You may assume water is surrounding the
grid (i.e., all the edges are water).

Example 1:

Input: grid = [
    ["0","1","1","1","0"],
    ["0","1","0","1","0"],
    ["1","1","0","0","0"],
    ["0","0","0","0","0"]
  ]
Output: 1

Time complexity: O(m * n)
Space complexity: O(m * n)

*/

public class ProblemNC31 {
    public static void main(String[] args) {
        SolutionNC31 solution = new SolutionNC31();

        char[][] grid = {{'0', '1', '1', '1', '0'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(grid));
    }

}

class SolutionNC31 {

    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numIslands(char[][] grid) {
        int noIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    noIslands++;
                }
            }
        }

        return noIslands;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1]);
        }
    }
}