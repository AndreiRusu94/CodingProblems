package second;

/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
Example 2:

Input: nums = [0]
Output: [0]
 */

import java.util.Arrays;

public class Problem283 {
    public static void main(String[] args) {
        Solution283 sol = new Solution283();
        int[] nums = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution283 {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else {
                nums[i - zeroCount] = nums[i];
            }
        }

        for (int i = 0; i < zeroCount; i++) {
            nums[nums.length - i - 1] = 0;
        }
    }
}