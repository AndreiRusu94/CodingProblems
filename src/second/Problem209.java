package second;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */

public class Problem209 {

    public static void main(String[] args) {
        Solution209 solution = new Solution209();
        int[] height = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(7, height));
    }
}

class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int left = 0, currentSum = 0;

        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            while (currentSum >= target) {
                if (minLength > right - left + 1) {
                    minLength = right - left + 1;
                }

                currentSum -= nums[left];
                left++;
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}
