package second;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1_1 {
    public static void main(String[] args) {
        Solution1_1 solution = new Solution1_1();

        int[] nums = {2, 7, 12, 15};
        int target = 9;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));
    }
}

class Solution1_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            var indexOfTarget = numToIndex.get(target - nums[i]);
            if (indexOfTarget == null) {
                numToIndex.put(nums[i], i);
            } else {
                return new int[]{i, indexOfTarget};
            }
        }

        return new int[2];
    }
}
