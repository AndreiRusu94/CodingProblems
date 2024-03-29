package first;
/*
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

  Example 1:

    Input: [3,6,9,1]
    Output: 3
    Explanation: The sorted form of the array is [1,3,6,9], either
                 (3,6) or (6,9) has the maximum difference 3.

  Example 2:

    Input: [10]
    Output: 0
    Explanation: The array contains less than 2 elements, therefore return 0.
*/

import java.util.Arrays;

public class Problem164 {
    public static void main(String[] args) {
        Solution164 solution = new Solution164();
        int[] nums = {4, 5, 9, 2, 4, 6};

        System.out.println("The maximum gap is: " + solution.maximumGap(nums));
    }
}


class Solution164 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        Arrays.sort(nums);

        int maxGap = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {
            maxGap = Math.max(maxGap, nums[i + 1] - nums[i]);
        }

        return maxGap;
    }
}


