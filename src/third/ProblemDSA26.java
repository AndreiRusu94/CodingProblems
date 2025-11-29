package third;

/*
Given an integer array of coins[] of size n representing different types of denominations and an integer sum, the task is to count all
combinations of coins to make a given value sum.

Note: Assume that you have an infinite supply of each type of coin.

Examples:

Input: sum = 4, coins[] = [1, 2, 3]
Output: 4
Explanation: There are four solutions: [1, 1, 1, 1], [1, 1, 2], [2, 2] and [1, 3]

Input: sum = 10, coins[] = [2, 5, 3, 6]
Output: 5
Explanation: There are five solutions:
[2, 2, 2, 2, 2], [2, 2, 3, 3], [2, 2, 6], [2, 3, 5] and [5, 5]

Input: sum = 10, coins[] = [10]
Output: 1
Explanation: The only is to pick 1 coin of value 10.

Input: sum = 5, coins[] = [4]
Output: 0
Explanation:  We cannot make sum 5 with the given coins
*/

public class ProblemDSA26 {

    public static void main(String[] args) {
        SolutionDSA26 solution = new SolutionDSA26();
        System.out.println(solution.count(new int[]{2, 5, 3, 6}, 10));
    }
}

class SolutionDSA26 {
    public int count(int[] coins, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[sum];
    }

}