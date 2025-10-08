package third;
/*
Given an array arr[] of size n which represents a row of n coins of values V1 . . . Vn, where n is even. We play a game against an opponent by
alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives
the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.

Note: The opponent is as clever as the user.

Examples:

Input: arr[] = [5, 3, 7, 10]
Output: 15 -> (10 + 5)
Explanation: The user collects the maximum value as 15(10 + 5). It is guaranteed that we cannot get more than 15 by any possible moves.

Input: arr[] = [8, 15, 3, 7]
Output: 22 -> (7 + 15)
Explanation: The user collects the maximum value as 22(7 + 15). It is guaranteed that we cannot get more than 22 by any possible moves.

*/

import java.util.Arrays;

public class ProblemDSA91 {
    public static void main(String[] args) {
        SolutionDSA91 solution = new SolutionDSA91();

        int[] coins = {5, 3, 7, 10};
        System.out.println(solution.maximumAmount(coins));
    }
}

class SolutionDSA91 {

    public int maximumAmount(int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return maxAmount(coins, memo, 0, n - 1);
    }

    private int maxAmount(int[] coins, int[][] memo, int i, int j) {
        if (i > j) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int leftTaken = coins[i] + Math.min(maxAmount(coins, memo, i + 2, j), maxAmount(coins, memo, i + 1, j - 1));
        int rightTaken = coins[j] + Math.min(maxAmount(coins, memo, i, j - 2), maxAmount(coins, memo, i + 1, j - 1));

        return Math.max(leftTaken, rightTaken);
    }


}

