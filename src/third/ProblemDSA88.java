package third;
/*
Given an array arr[] of size n, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of
abs(sum(Subset1) - sum(Subset2)) should be minimum.

Example:

Input: arr = [1, 6, 11, 5]
Output: 1
Explanation: S1 = [1, 5, 6], sum = 12,  S2 = [11], sum = 11,  Absolute Difference (12 - 11) = 1

Input: arr = [1, 5, 11, 5]
Output: 0
Explanation: S1 = [1, 5, 5], sum = 11, S2 = [11], sum = 11, Absolute Difference (11 - 11) = 0
*/

public class ProblemDSA88 {
    public static void main(String[] args) {
        SolutionDSA88 solution = new SolutionDSA88();

        System.out.println(solution.minDifference(new int[]{1, 5, 11, 5}));
    }
}

class SolutionDSA88 {

    public int minDifference(int[] arr) {
        int totalSum = 0;
        for (int i : arr) {
            totalSum += i;
        }

        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][totalSum + 1];
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= totalSum; sum++) {
                //exclude the element
                dp[i][sum] = dp[i - 1][sum];

                //include the element
                if (arr[i - 1] <= sum) {
                    dp[i][sum] = dp[i][sum] || dp[i - 1][sum - arr[i - 1]];
                }
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int sum = 0; sum <= totalSum / 2; sum++) {
            if (dp[n][sum]) {
                minDiff = Math.min(minDiff, Math.abs((totalSum - sum) - sum));
            }
        }

        return minDiff;
    }
}

