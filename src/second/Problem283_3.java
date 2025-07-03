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

public class Problem283_3 {
    public static void main(String[] args) {
        Solution283_3 sol = new Solution283_3();
        int[] nums = {0, 1, 0, 3, 12};
        sol.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution283_3 {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0 && nums[slow] == 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
            }

            if (nums[slow] != 0) {
                slow++;
            }
        }
    }
}