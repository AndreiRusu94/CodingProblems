package first;
/*
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

  Example 1:
    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]

  Example 2:
    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]
 */

import java.util.Arrays;

public class Problem34 {
    public static void main(String[] args) {
        Solution34 solution = new Solution34();

        int[] input = {1, 2, 3, 5, 5, 6};
        System.out.println(Arrays.toString(solution.searchRange(input, 5)));
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int start = -1, end = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == target) {
                if (start < 0) {
                    start = i;
                    end = i;
                } else {
                    end++;
                }
            }

            if (nums[i] > target) {
                return new int[]{start, end};
            }
        }

        if (nums[nums.length - 1] == target) {
            if (start < 0) {
                start = nums.length - 1;
            }
            end = nums.length - 1;
        }

        return new int[]{start, end};
    }
}