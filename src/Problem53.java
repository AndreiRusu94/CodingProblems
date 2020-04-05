/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

  Example:

    Input: [-2,1,-3,4,-1,2,1,-5,4],
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
 */

public class Problem53 {
    public static void main(String[] args) {
        Solution53 solution = new Solution53();

        int[] nums = {2, -3, 4, -5, 1, 1, -3};

        System.out.println(solution.maxSubArray(nums));
    }
}

class Solution53 {
    public int maxSubArray(int[] nums) {
        int maxEnding = nums[0];
        int maxEndingSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingSoFar = Math.max(maxEndingSoFar + nums[i], nums[i]);
            maxEnding = Math.max(maxEnding, maxEndingSoFar);
        }

        return maxEnding;
    }
}