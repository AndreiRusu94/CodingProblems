package second;
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

  Example 1:

    Input: [1,2,3,1]
    Output: 4
    Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
                 Total amount you can rob = 1 + 3 = 4.

  Example 2:

    Input: [2,7,9,3,1]
    Output: 12
    Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
                 Total amount you can rob = 2 + 9 + 1 = 12.
*/

public class Problem198 {
    public static void main(String[] args) {
        Solution198 solution = new Solution198();

        int[] nums = {1, 2, 3, 4, 2};
        System.out.println(solution.rob(nums));
    }
}


class Solution198 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + nums[i]);
        }

        return memo[nums.length];
    }
}


