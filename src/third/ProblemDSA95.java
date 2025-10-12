package third;
/*
Given a square binary matrix mat[][] representing a maze. A rat starts at the top-left corner (0,0) and needs to reach the bottom-right corner
(n-1, n-1). The rat can move in four directions: Up (U), Down (D), Left (L), Right (R).
Find all possible paths from (0, 0) to (n-1, n-1). If multiple paths exist, return them in lexicographically sorted order otherwise If no path
exists, return empty list.

Note:

A rat cannot visit the same cell more than once in a path.
1 represents an open cell (rat can visit), and 0 represents a blocked cell (rat cannot visit).
Example:

Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]

1

Output: ["DDRDRR", "DRDDRR"]

*/

import java.util.ArrayList;
import java.util.List;

public class ProblemDSA95 {
    public static void main(String[] args) {
        SolutionDSA95 solution = new SolutionDSA95();

        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}
        };

        System.out.println(solution.ratInMaze(maze));
    }
}

class SolutionDSA95 {

    private static final String DIR = "DLRU";

    public List<String> ratInMaze(int[][] maze) {
        List<String> output = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backtracking(0, 0, maze, output, path);

        return output;
    }

    private void backtracking(int x, int y, int[][] maze, List<String> output, StringBuilder path) {
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            output.add(path.toString());
            return;
        }

        maze[x][y] = 0;

        int[][] dirs = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        for (int i = 0; i < dirs.length; i++) {
            int newX = x + dirs[i][0];
            int newY = y + dirs[i][1];

            if (isValid(newX, newY, maze)) {
                path.append(DIR.charAt(i));
                backtracking(newX, newY, maze, output, path);
                path.deleteCharAt(path.length() - 1);
            }
        }

        maze[x][y] = 1;
    }

    private boolean isValid(int x, int y, int[][] maze) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
    }


}

