package third;
/*
Given a binary 2D matrix, find area of the largest region of 1s which are connected horizontally, vertically or diagonally.

Examples:

Input: M[][]= {{1, 0, 0, 0, 1, 0, 0},
                         {0, 1, 0, 0, 1, 1, 0},
                         {1, 1, 0, 0, 0, 0, 0},
                         {1, 0, 0, 1, 1, 0, 0},
                         {1, 0, 0, 1, 0, 1, 1}}

Output: 6
Explanation: The region in red has the largest area of 6 cells.

Max-Area-of-Island
Area of Largest Region is 6

Input: M[][] = {{0, 0, 1, 1, 0},
                          {1, 0, 1, 1, 0},
                          {0, 1, 0, 0, 0},
                          {0, 0, 0, 0, 1}}
Output: 6
Explanation: In the following example, there are 2 regions. One with area = 1 and other with area = 6. So, largest area = 6.

*/

public class ProblemDSA68 {
    public static void main(String[] args) {
        SolutionDSA68 solution = new SolutionDSA68();

        int[][] m = {{0, 0, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1}};

        System.out.println(solution.largestRegion(m));
    }
}

class SolutionDSA68 {

    public static final int[] DY = new int[]{-1, -1, -1, 0, 1, 1, 1, 1};
    public static final int[] DX = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public int largestRegion(int[][] m) {
        int largest = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 1) {
                    int area = DFS(m, i, j);
                    largest = Math.max(largest, area);
                }
            }
        }

        return largest;
    }

    private int DFS(int[][] m, int x, int y) {
        if (!isValid(x, y, m.length, m[0].length, m)) {
            return 0;
        }

        m[x][y] = 0;
        int area = 1;

        for (int i = 0; i < 8; i++) {
            int newX = DX[i] + x;
            int newY = DY[i] + y;

            area += DFS(m, newX, newY);
        }

        return area;
    }

    private boolean isValid(int x, int y, int n, int m, int[][] M) {
        return x >= 0 && x < n && y >= 0 && y < m && M[x][y] == 1;
    }

}