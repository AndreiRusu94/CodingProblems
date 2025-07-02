package second;

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true
 */

import java.util.HashSet;
import java.util.Set;

public class Problem217 {
    public static void main(String[] args) {
        Solution217 sol = new Solution217();
        int[] nums1 = {1, 1, 1, 2, 2, 2, 2, 3, 4};
        System.out.println(sol.containsDuplicate(nums1));
    }
}

class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (numbers.contains(nums[i])) {
                return true;
            }

            numbers.add(nums[i]);
        }

        return false;
    }
}