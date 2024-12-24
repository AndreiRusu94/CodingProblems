package second;

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */

import java.util.HashMap;
import java.util.Map;

public class Problem169 {
    public static void main(String[] args) {
        Solution169 sol = new Solution169();
        int[] nums1 = {1, 1, 1, 2, 2, 2, 2, 3, 4};
        System.out.println(sol.majorityElement(nums1));
    }
}

class Solution169 {
    public int majorityElement(int[] nums) {
        int majority = 0, valueOfMajority = nums[0];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            var current = map.compute(num, (k, v) -> (v == null) ? 1 : v + 1);
            if (current > majority) {
                majority = current;
                valueOfMajority = num;
            }
        }

        return valueOfMajority;
    }
}