package second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
 */

public class Problem15 {
    public static void main(String[] args) {
        Solution15 solution = new Solution15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        for (List<Integer> integers : solution.threeSum(nums)) {
            System.out.println(integers);
        }
    }
}

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();

        if (nums == null || nums.length < 3) {
            return output;
        }

        Arrays.sort(nums);
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = -nums[i] - nums[j];

                if (numToIndex.get(target) != null && numToIndex.get(target) > j) {
                    output.add(Arrays.asList(nums[i], nums[j], target));
                    j = numToIndex.get(nums[j]);
                }

                i = numToIndex.get(nums[i]);
            }
        }

        return output;
    }
}