/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

  Example 1:
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4

  Example 2:
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
 */

import java.util.Arrays;

public class Problem33 {
    public static void main(String[] args) {
        Solution33 solution = new Solution33();

        int[] input = {1, 2, 3, 8, 5, 6};
        System.out.println(solution.search(input, 5));
    }
}

class Solution33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return (nums[0] == target) ? 0 : -1;
        }

        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }

        boolean pivotFound = false;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == target) {
                return i;
            }

            if (pivotFound) {
                if (nums[i] > target) {
                    return -1;
                }
            } else {
                if (i == nums.length-2) {
                    return (nums[i+1] == target) ? i+1 : -1;
                }

                if (nums[i] > nums[i+1]) {
                    pivotFound = true;
                }
            }
        }

        return -1;
    }
}