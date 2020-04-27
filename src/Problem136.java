/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

  Example 1:

    Input: [2,2,1]
    Output: 1

  Example 2:

    Input: [4,1,2,1,2]
    Output: 4
*/

import java.util.Arrays;

public class Problem136 {
    public static void main(String[] args) {
        Solution136 solution = new Solution136();

        int[] nums = {1, 2, 2, 4, 4};
        System.out.println(solution.singleNumber(nums));
    }
}

class Solution136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for (int left = 0; left < nums.length; left++) {
            int current = nums[left];
            boolean found = false;

            if (left == nums.length - 1) {
                return current;
            }

            for (int i = left + 1; i < nums.length; i++) {
                if (current == nums[i]) {
                    found = true;
                    left++;
                    break;
                }
            }

            if (!found) {
                return current;
            }
        }

        return -1;
    }
}
