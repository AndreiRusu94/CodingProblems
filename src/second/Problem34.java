package second;
/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
*/

import java.util.Arrays;

public class Problem34 {
    public static void main(String[] args) {
        Solution34 solution = new Solution34();

        System.out.println("[LeftIndex, RightIndex] of target: " + Arrays.toString(solution.searchRange(new int[]{0, 1, 2, 3, 4, 5, 5, 6, 7, 8, 9}, 5)));
    }
}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int leftIndex = binarySearch(nums, target, true);
        int rightIndex = binarySearch(nums, target, false);

        return new int[]{leftIndex, rightIndex};
    }

    private int binarySearch(int[] nums, int target, boolean searchLeft) {
        int left = 0, right = nums.length - 1, indx = -1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                indx = middle;
                if (searchLeft) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
        }

        return indx;
    }
}
