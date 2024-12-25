package second;

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */

import java.util.Arrays;

public class Problem238 {
    public static void main(String[] args) {
        Solution238 sol = new Solution238();
        int[] nums1 = {1, 3, 1, 4};
        System.out.println(Arrays.toString(sol.productExceptSelf(nums1)));
    }
}

class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        int[] prefix = new int[n];
        int[] output = new int[n];
        prefix[0] = 1;
        suffix[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            output[i] = suffix[i] * prefix[i];
        }

        return output;
    }
}