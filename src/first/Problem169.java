package first;
/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

  Example 1:

    Input: [3,2,3]
    Output: 3

  Example 2:

    Input: [2,2,1,1,1,2,2]
    Output: 2
*/

import java.util.HashMap;
import java.util.Map;

public class Problem169 {
    public static void main(String[] args) {
        Solution169 solution = new Solution169();

        int[] nums = {2, 3, 3, 2, 4, 5, 6};
        System.out.println(solution.majorityElement(nums));
    }
}


class Solution169 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> numToCount = new HashMap<>();
        int majorityCount = 0, majorityValue = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = numToCount.getOrDefault(nums[i], 0);
            count++;

            if (count > majorityCount) {
                majorityCount = count;
                majorityValue = nums[i];
            }

            numToCount.put(nums[i], count);
        }

        return majorityValue;
    }
}


