package third;
/*
Given a square matrix mat[][] of size n x n, where mat[i][j] == 1 means person i knows person j, and mat[i][j] == 0 means person i does not know person j, the objective is to find the celebrity.

A celebrity is defined as someone who:

Is known by everyone else
Does not know anyone (except themselves)
Return the index of the celebrity if one exists, otherwise return -1.

Note:

Use 0-based indexing
It is guaranteed that mat[i][i] == 1 for all i
Examples:

Input: mat[][] = [[1, 1, 0],
                             [0, 1, 0],
                             [0, 1, 1]]
Output: 1
Explanation: 0th and 2nd person both know 1. Therefore, 1 is the celebrity.

Input: mat[][] = [[1, 1],
                             [1, 1]]
Output: -1
Explanation: The two people at the party both know each other. None of them is a celebrity.

Input: mat[][] = [[1]]
Output: 0
 */

public class ProblemDSA39 {
    public static void main(String[] args) {
        SolutionDSA39 solution = new SolutionDSA39();

        int[][] mat = new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 1}};
        System.out.println("Celebrity index: " + solution.celebrity(mat));
    }
}

class SolutionDSA39 {
    public int celebrity(int[][] mat) {
        int n = mat.length;

        int i = 0, j = n - 1;

        while (i < j) {
            if (mat[j][i] == 1) {
                j--;
            } else {
                i++;
            }
        }

        int candidate = i;

        for (i = 0; i < n; i++) {
            if (candidate == i) {
                continue;
            }

            if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                return -1;
            }
        }

        return candidate;
    }


}