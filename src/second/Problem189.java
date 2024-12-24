package second;

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 */

import java.util.Arrays;

public class Problem189 {
    public static void main(String[] args) {
        Solution189 sol = new Solution189();
        int[] nums1 = {1, 1, 1, 2, 2, 2, 2, 3, 4};
        sol.rotate(nums1, 2);
        System.out.println(Arrays.toString(nums1));
    }
}

class Solution189 {
    public void rotate(int[] nums, int k) {
        int initialLength = nums.length;
        int[] output = new int[initialLength];
        for (int i = 0; i < initialLength; i++) {
            output[(i + k) % initialLength] = nums[i];
        }

        System.arraycopy(output, 0, nums, 0, initialLength);
    }
}