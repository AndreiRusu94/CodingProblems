package fourth;
/*
You are given an integer array nums where nums[i] represents the amount of money the ith house has. The houses are arranged in a straight line, i.e.
the ith house is the neighbor of the (i-1)th and (i+1)th house.

You are planning to rob money from the houses, but you cannot rob two adjacent houses because the security system will automatically alert
the police if two adjacent houses were both broken into.

Return the maximum amount of money you can rob without alerting the police.

Example 1:

Input: nums = [1,1,3,3]

Output: 4
Explanation: nums[0] + nums[2] = 1 + 3 = 4.

Example 2:

Input: nums = [2,9,8,3,6]

Output: 16

*/

import java.util.Arrays;

public class ProblemNC25 {
    public static void main(String[] args) {
        SolutionNC25 solution = new SolutionNC25();

        System.out.println(solution.rob(new int[]{1, 1, 3, 3}));
    }

}

class SolutionNC25 {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dfs(nums, memo, 0);
    }

    private int dfs(int[] nums, int[] memo, int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != -1) {
            return memo[i];
        }

        memo[i] = Math.max(dfs(nums, memo, i + 1), nums[i] + dfs(nums, memo, i + 2));
        return memo[i];
    }
}