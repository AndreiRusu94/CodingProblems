package fourth;
/*
Kadane's Algorithm:

Given an array of integers nums, find the subarray with the largest sum and return the sum.

A subarray is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [2,-3,4,-2,2,1,-1,4]

Output: 8
Explanation: The subarray [4,-2,2,1,-1,4] has the largest sum 8.

Example 2:

Input: nums = [-1]

Output: -1
*/

public class ProblemNC59 {
    public static void main(String[] args) {
        SolutionNC59 solution = new SolutionNC59();
        System.out.println(solution.maxSubArray(new int[]{1, 7, 3, 6, 5, 6}));
    }
}

class SolutionNC59 {

    public int maxSubArray(int[] nums) {
        int currSum = 0, maxSum = nums[0];

        for (int num : nums) {
            if (currSum < 0) {
                currSum = 0;
            }

            currSum += num;
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

}

