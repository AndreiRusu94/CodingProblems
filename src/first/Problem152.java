package first;
/*
Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

  Example 1:

    Input: [2,3,-2,4]
    Output: 6
    Explanation: [2,3] has the largest product 6.

  Example 2:

    Input: [-2,0,-1]
    Output: 0
    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

public class Problem152 {
    public static void main(String[] args) {
        Solution152 solution = new Solution152();

        int[] nums = {2, 4, -1, 5, -2, -1};
        System.out.println(solution.maxProduct(nums));
    }
}

class Solution152 {
    public int maxProduct(int[] nums) {
        int maximum = nums[0];

        for (int i = 1, currentMaximum = maximum, currentMinimum = maximum; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = currentMaximum;
                currentMaximum = currentMinimum;
                currentMinimum = temp;
            }

            currentMaximum = Math.max(nums[i], currentMaximum * nums[i]);
            currentMinimum = Math.min(nums[i], currentMinimum * nums[i]);

            maximum = Math.max(currentMaximum, maximum);
        }

        return maximum;
    }
}
