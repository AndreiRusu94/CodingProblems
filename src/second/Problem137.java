package second;
/*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
*/

public class Problem137 {
    public static void main(String[] args) {
        Solution137 solution = new Solution137();

        System.out.println(solution.singleNumber(new int[]{2, 2, 1}));
    }
}


class Solution137 {
    public int singleNumber(int[] nums) {
        int output = 0;
        for (int i = 0; i < nums.length; i++) {
            output = output ^ nums[i];
        }

        return output;
    }
}


