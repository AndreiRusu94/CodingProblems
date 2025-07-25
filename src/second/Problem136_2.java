package second;
/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]

Output: 1

Example 2:

Input: nums = [4,1,2,1,2]

Output: 4

Example 3:

Input: nums = [1]

Output: 1
*/

public class Problem136_2 {
    public static void main(String[] args) {
        Solution136_2 solution = new Solution136_2();

        System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
    }
}


class Solution136_2 {
    public int singleNumber(int[] nums) {
        int output = 0;
        for (int i = 0; i < nums.length; i++) {
            output = output ^ nums[i];
        }

        return output;
    }
}


