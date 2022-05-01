package first;
/*
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

  Example:

    Input: [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]
 */


import java.util.Arrays;

public class Problem75 {
    public static void main(String[] args) {
        Solution75 solution = new Solution75();

        int[] nums = {1, 0, 2, 1};
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int j = 0, n = nums.length - 1;

        for (int i = 0; i <= n; i++) {
            if (nums[i] == 0 && i != j) {
                swap(nums, i--, j++);
            } else {
                if (nums[i] == 2 && i != n) {
                    swap(nums, i--, n--);
                }
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
