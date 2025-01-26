package second;

/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */

import java.util.HashMap;
import java.util.Map;

public class Problem219 {
    public static void main(String[] args) {
        Solution219 solution = new Solution219();

        System.out.println("Contains duplicates within interval " + solution.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 2));
    }
}

class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            var index = numToIndex.get(nums[i]);
            if (index != null) {
                if (i - index <= k) {
                    return true;
                }
            }
            numToIndex.put(nums[i], i);
        }

        return false;
    }
}
