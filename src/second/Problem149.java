package second;
/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

Input: points = [[1,1],[2,2],[3,3]]
Output: 3

Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4

*/

public class Problem149 {
    public static void main(String[] args) {
        Solution149 solution = new Solution149();

        System.out.println("Longest line has number of points: " + solution.maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}}));
    }
}


class Solution149 {
    public int maxPoints(int[][] points) {
        int n = points.length;

        if (n <= 2) {
            return n;
        }

        int output = 2;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = 2;
                for (int k = j + 1; k < n; k++) {
                    int x = (points[j][1] - points[i][1]) * (points[k][0] - points[i][0]);
                    int y = (points[k][1] - points[i][1]) * (points[j][0] - points[i][0]);

                    if (x == y) {
                        temp++;
                    }
                }

                if (temp > output) {
                    output = temp;
                }
            }
        }

        return output;
    }
}


