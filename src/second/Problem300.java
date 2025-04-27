package second;
/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
*/

import java.util.Arrays;

public class Problem300 {
    public static void main(String[] args) {
        Solution300 solution = new Solution300();

        System.out.println(solution.lengthOfLIS(new int[]{1, 2, 5, 4, 4, 6, 5}));
    }
}


class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int[] maxLengths = new int[nums.length + 1];
        int maximum = 1;
        Arrays.fill(maxLengths, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxLengths[i] = Math.max(maxLengths[j] + 1, maxLengths[i]);
                    if (maxLengths[i] > maximum) {
                        maximum = maxLengths[i];
                    }
                }
            }
        }

        return maximum;
    }
}


