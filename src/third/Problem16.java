package third;
/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 
*/

import java.util.Arrays;

public class Problem16 {
    public static void main(String[] args) {
        Solution16 solution = new Solution16();

        System.out.println(solution.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                int current = nums[i] + nums[left] + nums[right];
                if (current == target) {
                    return target;
                }

                if (Math.abs(target - current) < Math.abs(target - closest)) {
                    closest = current;
                }

                if (current < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closest;
    }
}
