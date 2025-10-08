package third;
/*
Given a distance 'dist', count total number of ways to cover the distance with 1, 2 and 3 steps.

Examples:

Input: n = 3
Output: 4
Explanation: Below are the four ways
=> 1 step + 1 step + 1 step
=> 1 step + 2 step
=> 2 step + 1 step
=> 3 step

Input: n = 4
Output: 7
Explanation: Below are the four ways
=> 1 step + 1 step + 1 step + 1 step
=> 1 step + 2 step + 1 step
=>  2 step + 1 step + 1 step
=>  1 step + 1 step + 2 step
=>  2 step + 2 step
=>  3 step + 1 step
=>  1 step + 3 step


*/

public class ProblemDSA89 {
    public static void main(String[] args) {
        SolutionDSA89 solution = new SolutionDSA89();

        System.out.println(solution.printCountDP(6));
    }
}

class SolutionDSA89 {

    public int printCountDP(int dist) {
        int[] dp = new int[dist + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= dist; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[dist];
    }
}

